package com.example.DTO.POJO;

import java.util.ArrayList;

public class GraphPOJO {
    private int id;
    private ArrayList<String> nodes;
    private ArrayList<EdgePOJO> edges;

    public GraphPOJO() {}

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

    public void setEdges(ArrayList<EdgePOJO> edges) {
        this.edges = edges;
    }

    public ArrayList<EdgePOJO> getEdges() {
        return edges;
    }
}
