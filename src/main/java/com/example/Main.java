package com.example;

import com.example.model.Graph;
import com.example.model.Graphs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream input = Main.class.getResourceAsStream("/ass_3_input.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Graphs graphs = mapper.readValue(input, Graphs.class);

        Graph graph = graphs.getGraphs().getFirst();

        System.out.println(mapper.writer().writeValueAsString(graph));
    }
}