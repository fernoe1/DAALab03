package com.example.model;

public class Edge implements Comparable<Edge> {
    private int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getSrc() {
        return src;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getDest() {
        return dest;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Compare two edges based on weight.
     * @param compareEdge the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }

    @Override
    public String toString() {
        return src + " - " + dest + " (" + weight + ")";
    }
}