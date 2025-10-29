package com.example.DTO;

import com.example.DTO.POJO.ResultPOJO;

import java.util.ArrayList;

public class OutputDTO {
    private ArrayList<ResultPOJO> results;

    public OutputDTO() {
        results = new ArrayList<>();
    }

    public void setResults(ArrayList<ResultPOJO> results) {
        this.results = results;
    }

    public ArrayList<ResultPOJO> getResults() {
        return results;
    }
}
