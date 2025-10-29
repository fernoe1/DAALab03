package com.example.util;

import com.example.model.Graph;

import java.util.Random;

public class GraphGenerator {
    /**
     * Generates a random undirected weighted graph.
     *
     * @param n         number of vertices.
     * @param density   determines how connected the graph should be (0.0–1.0).
     *                  example: 0.3 = sparse, 0.7 = dense, 1.0 = fully connected.
     * @param maxWeight maximum edge weight
     * @return a randomly generated Graph instance.
     */
    public static Graph generateRandomGraph(int n, double density, int maxWeight) {
        if (n <= 0)
            throw new IllegalArgumentException("Number of vertices must be > 0");
        if (density <= 0 || density > 1)
            throw new IllegalArgumentException("Density must be between (0, 1]");
        if (maxWeight <= 0)
            throw new IllegalArgumentException("Max weight must be > 0");

        Graph graph = new Graph(n);
        Random rand = new Random();

        // Go through all possible pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Add edge with probability equal to density
                if (rand.nextDouble() <= density) {
                    int weight = 1 + rand.nextInt(maxWeight);
                    graph.addEdge(i, j, weight);
                }
            }
        }

        return graph;
    }
}