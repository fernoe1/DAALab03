package com.example.DTO;

import com.example.DTO.POJO.GraphPOJO;

import java.util.ArrayList;

public class InputDTO {
    private ArrayList<GraphPOJO> graphs;

    public InputDTO() {}

    public void setGraphs(ArrayList<GraphPOJO> graphs) {
        this.graphs = graphs;
    }

    public ArrayList<GraphPOJO> getGraphs() {
        return graphs;
    }
}
