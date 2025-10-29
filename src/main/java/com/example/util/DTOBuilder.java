package com.example.util;

import com.example.DTO.OutputDTO;
import com.example.DTO.POJO.*;
import com.example.model.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DTOBuilder {

    /**
     * Appends a new result to an existing OutputDTO.
     * If OutputDTO is null, a new one will be created.
     * @param outputDTO      existing OutputDTO (can be null).
     * @param graphId        unique graph identifier.
     * @param vertices       number of vertices.
     * @param edges          number of edges.
     * @param primResult     Prim's algorithm result (List<Edge>, Metric).
     * @param kruskalResult  Kruskal's algorithm result (List<Edge>, Metric).
     * @return updated OutputDTO containing the new result.
     */
    public static OutputDTO addGraphResult(
            OutputDTO outputDTO,
            int graphId,
            int vertices,
            int edges,
            Map.Entry<List<Edge>, Metric> primResult,
            Map.Entry<List<Edge>, Metric> kruskalResult
    ) {
        if (outputDTO == null) {
            outputDTO = new OutputDTO();
            outputDTO.setResults(new ArrayList<>());
        }

        List<Edge> primMST = primResult.getKey();
        Metric primMetric = primResult.getValue();

        List<Edge> kruskalMST = kruskalResult.getKey();
        Metric kruskalMetric = kruskalResult.getValue();

        InputStatsPOJO inputStats = new InputStatsPOJO();
        inputStats.setVertices(vertices);
        inputStats.setEdges(edges);

        AlgorithmPOJO primPOJO = new AlgorithmPOJO();
        primPOJO.setMst_edges(convertEdgesToPOJO(primMST));
        primPOJO.setTotal_cost(primMetric.getTotalCost());
        primPOJO.setOperations_count(primMetric.getOperations());
        primPOJO.setExecution_time_ms(primMetric.getExecutionTimeMs());

        AlgorithmPOJO kruskalPOJO = new AlgorithmPOJO();
        kruskalPOJO.setMst_edges(convertEdgesToPOJO(kruskalMST));
        kruskalPOJO.setTotal_cost(kruskalMetric.getTotalCost());
        kruskalPOJO.setOperations_count(kruskalMetric.getOperations());
        kruskalPOJO.setExecution_time_ms(kruskalMetric.getExecutionTimeMs());

        ResultPOJO result = new ResultPOJO();
        result.setGraph_id(graphId);
        result.setInput_stats(inputStats);
        result.setPrim(primPOJO);
        result.setKruskal(kruskalPOJO);

        outputDTO.getResults().add(result);
        return outputDTO;
    }

    /**
     * Converts model Edge list into EdgePOJO list for DTO.
     * @param mstEdges MST Edges.
     * @return EdgePOJO list.
     */
    private static ArrayList<EdgePOJO> convertEdgesToPOJO(List<Edge> mstEdges) {
        ArrayList<EdgePOJO> edgeList = new ArrayList<>();
        for (Edge e : mstEdges) {
            EdgePOJO edgePOJO = new EdgePOJO();
            edgePOJO.setFrom(String.valueOf((char) (e.getSrc() + 'a')));
            edgePOJO.setTo(String.valueOf((char) (e.getDest() + 'a')));
            edgePOJO.setWeight(e.getWeight());
            edgeList.add(edgePOJO);
        }
        return edgeList;
    }
}
