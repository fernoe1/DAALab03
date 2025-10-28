package com.example.model;

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

    /**
     * Adds edge to the graph.
     * @param src source vertex.
     * @param dest destination vertex.
     * @param weight weight of the vertex.
     */
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    /**
     * Find the root of a vertex.
     * @param parent array that stores connections.
     * @param i the vertex index.
     * @return the representative (root) of the subset containing vertex i.
     */
    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        parent[i] = find(parent, parent[i]); // path compression
        return parent[i];
    }

    /**
     * Combines two subsets into a single subset.
     * @param parent array that stores parent connections for each vertex.
     * @param x vertex.
     * @param y other vertex.
     */
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    /**
     * Kruskal's algorithm.
     * @return MST.
     */
    public List<Edge> kruskalMST() {
        Collections.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges) {
            int x = find(parent, edge.getSrc());
            int y = find(parent, edge.getDest());

            if (x != y) {
                result.add(edge);
                union(parent, x, y);
            }

            if (result.size() == V - 1)
                break;
        }

        return result;
    }

    /**
     * Prim's algorithm.
     * @return MST.
     */
    public List<Edge> primsMST() {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Min-heap based on edge weight
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getWt));

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            if (inMST[u])
                continue;
            inMST[u] = true;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.getV();
                int weight = neighbor.getWt();

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Pair(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        List<Edge> result = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            result.add(new Edge(parent[i], i, key[i]));
        }

        return result;
    }
}
