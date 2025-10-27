package com.example.model;

import java.util.*;

public class Graph {
    int V;  // Number of vertices
    List<Edge> edges;  // List of all edges

    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
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
     * @return MST
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
}
