package com.example.util;

public class Metric {
    private int totalCost, operations;
    private double executionTimeMs,     startTime;

    public Metric() {
        startTime = System.nanoTime();
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void increaseOperations() {
        operations++;
    }

    public int getOperations() {
        return operations;
    }

    public void finish() {
        executionTimeMs = Math.round(((System.nanoTime() - startTime) / 1000000) * 100.0) / 100.0;
    }

    public double getExecutionTimeMs() {
        return executionTimeMs;
    }
}
