package com.example.model;

import java.util.ArrayList;

public class Graph {
    private int id;
    private ArrayList<String> nodes;
    private ArrayList<Edge> edges;

    public Graph() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNodes(ArrayList<String> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<String> getNodes() {
        return nodes;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
