package com.example.DTO.POJO;

import java.util.ArrayList;

public class AlgorithmPOJO {
    private ArrayList<EdgePOJO> mst_edges;
    private int total_cost, operations_count;
    private double execution_time_ms;

    public void setMst_edges(ArrayList<EdgePOJO> mst_edges) {
        this.mst_edges = mst_edges;
    }

    public ArrayList<EdgePOJO> getMst_edges() {
        return mst_edges;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setOperations_count(int operations_count) {
        this.operations_count = operations_count;
    }

    public int getOperations_count() {
        return operations_count;
    }

    public void setExecution_time_ms(double execution_time_ms) {
        this.execution_time_ms = execution_time_ms;
    }

    public double getExecution_time_ms() {
        return execution_time_ms;
    }
}
