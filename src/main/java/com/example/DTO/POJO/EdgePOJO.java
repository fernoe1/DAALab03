package com.example.DTO.POJO;

public class EdgePOJO {
    private String from;
    private String to;
    private int weight;

    public EdgePOJO() {}

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
