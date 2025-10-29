package com.example.DTO.POJO;

public class ResultPOJO {
    private int graph_id;
    private InputStatsPOJO input_stats;
    private AlgorithmPOJO prim;
    private AlgorithmPOJO kruskal;

    public ResultPOJO() {
        input_stats = new InputStatsPOJO();
        prim = new AlgorithmPOJO();
        kruskal = new AlgorithmPOJO();
    }

    public void setGraph_id(int graph_id) {
        this.graph_id = graph_id;
    }

    public int getGraph_id() {
        return graph_id;
    }

    public void setInput_stats(InputStatsPOJO input_stats) {
        this.input_stats = input_stats;
    }

    public InputStatsPOJO getInput_stats() {
        return input_stats;
    }

    public void setPrim(AlgorithmPOJO prim) {
        this.prim = prim;
    }

    public AlgorithmPOJO getPrim() {
        return prim;
    }

    public void setKruskal(AlgorithmPOJO kruskal) {
        this.kruskal = kruskal;
    }

    public AlgorithmPOJO getKruskal() {
        return kruskal;
    }
}
