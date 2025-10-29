package com.example.DTO;

import com.example.DTO.POJO.GraphPOJO;
import com.example.model.Edge;
import com.example.model.Graph;

import java.util.ArrayList;
import java.util.List;

public class InputDTO {
    private ArrayList<GraphPOJO> graphs;

    public InputDTO() {}

    public void setGraphs(ArrayList<GraphPOJO> graphs) {
        this.graphs = graphs;
    }

    public ArrayList<GraphPOJO> getGraphs() {
        return graphs;
    }

    public List<Graph> convertToGraph() {
        ArrayList<Graph> graphs = new ArrayList<>(this.graphs.size());

        for (int i = 0; i < this.graphs.size(); i++) {
            graphs.add(new Graph(this.graphs.get(i).getNodes().size()));
            for (int j = 0; j < this.graphs.get(i).getEdges().size(); j++) {
                graphs.get(i).addEdge(
                        this.graphs.get(i).getEdges().get(j).getFrom().charAt(0) - 'A',
                        this.graphs.get(i).getEdges().get(j).getTo().charAt(0) - 'A',
                        this.graphs.get(i).getEdges().get(j).getWeight());
            }
        }

        return graphs;
    }
}
