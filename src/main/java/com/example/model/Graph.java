package com.example.model;

import com.example.util.Metric;

import java.util.*;

public class Graph {
    private int V;  // Number of vertices
    private List<Edge> edges;  // List of all edges
    private List<List<Pair>> adj; // Adjacency list for Prim's algorithm

    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
        this.adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public int getV() {
        return V;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Adds edge to the graph.
     * @param src source vertex.
     * @param dest destination vertex.
     * @param weight weight of the vertex.
     */
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
        adj.get(src).add(new Pair(dest, weight));
        adj.get(dest).add(new Pair(src, weight));
    }

    /**
     * Find the root of a vertex.
     * @param parent array that stores connections.
     * @param i the vertex index.
     * @return the representative (root) of the subset containing vertex i.
     */
    private int find(int[] parent, int i, Metric metric) {
        metric.increaseOperations(); // visiting a node in disjoint set
        if (parent[i] == -1)
            return i;
        parent[i] = find(parent, parent[i], metric);
        return parent[i];
    }

    /**
     * Combines two subsets into a single subset.
     * @param parent array that stores parent connections for each vertex.
     * @param x vertex.
     * @param y other vertex.
     */
    private void union(int[] parent, int x, int y, Metric metric) {
        int xset = find(parent, x, metric);
        int yset = find(parent, y, metric);
        metric.increaseOperations(); // merging two sets
        parent[xset] = yset;
    }

    /**
     * Kruskal's algorithm.
     * @return MST.
     */
    public Map.Entry<List<Edge>, Metric> kruskalMST() {
        Metric metric = new Metric();

        Collections.sort(edges);
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges) {
            metric.increaseOperations(); // checking an edge

            int x = find(parent, edge.getSrc(), metric);
            int y = find(parent, edge.getDest(), metric);

            if (x != y) {
                result.add(edge);
                metric.setTotalCost(metric.getTotalCost() + edge.getWeight());
                union(parent, x, y, metric);
            }

            if (result.size() == V - 1)
                break;
        }

        metric.finish();
        return new AbstractMap.SimpleEntry<>(result, metric);
    }

    /**
     * Prim's algorithm.
     * @return MST.
     */
    public Map.Entry<List<Edge>, Metric> primsMST() {
        Metric metric = new Metric();

        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getWt));

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Pair(0, 0));
        metric.increaseOperations(); // enqueue first vertex

        while (!pq.isEmpty()) {
            metric.increaseOperations(); // poll operation
            int u = pq.poll().getV();

            if (inMST[u]) continue;

            inMST[u] = true;
            metric.increaseOperations(); // marking a vertex as part of MST

            for (Pair neighbor : adj.get(u)) {
                metric.increaseOperations(); // edge inspection

                int v = neighbor.getV();
                int weight = neighbor.getWt();

                // Only consider vertices not in MST and with smaller edge weight
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Pair(v, key[v]));
                    metric.increaseOperations(); // edge relaxation
                }
            }
        }

        List<Edge> result = new ArrayList<>();
        int totalCost = 0;

        for (int i = 1; i < V; i++) {
            metric.increaseOperations();
            if (parent[i] != -1 && key[i] != Integer.MAX_VALUE) {
                result.add(new Edge(parent[i], i, key[i]));
                totalCost += key[i];
            }
        }

        metric.setTotalCost(totalCost);
        metric.finish();
        return new AbstractMap.SimpleEntry<>(result, metric);
    }
}
