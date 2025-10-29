package com.example.cli;

import com.example.DTO.InputDTO;
import com.example.DTO.OutputDTO;
import com.example.DTO.POJO.ResultPOJO;
import com.example.Main;
import com.example.model.Edge;
import com.example.model.Graph;
import com.example.util.DTOBuilder;
import com.example.util.GraphGenerator;
import com.example.util.JsonUtil;
import com.example.util.Metric;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CLI {
    private static int graphId = 1;

    public static void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        OutputDTO outputDTO = new OutputDTO();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        while (true) {
            System.out.println("[0] Run algorithms on small input (n=100) \n" +
                    "[1] Run algorithms on medium input (n=500) \n" +
                    "[2] Run algorithms on large input (n=1000) \n" +
                    "[3] Run algorithms on default input (ass_3_input.json) \n" +
                    "[4] Print current OutputDTO \n" +
                    "[5] Write to src/main/resources/ass_3_output.json (Exit)");

            int input = sc.nextInt();

            switch (input) {
                case 0: {
                    Graph graph = GraphGenerator.generateRandomGraph(100, 0.5, 100);
                    addToOutputDTO(outputDTO, mapper, graph);
                }
                    break;
                case 1: {
                    Graph graph = GraphGenerator.generateRandomGraph(500, 0.5, 100);
                    addToOutputDTO(outputDTO, mapper, graph);
                }
                    break;
                case 2: {
                    Graph graph = GraphGenerator.generateRandomGraph(1000, 0.5, 100);
                    addToOutputDTO(outputDTO, mapper, graph);
                }
                    break;
                case 3: {
                    InputStream inputStream = Main.class.getResourceAsStream("/ass_3_input.json");
                    InputDTO inputDTO = mapper.readValue(inputStream, InputDTO.class);
                    List<Graph> graphs = inputDTO.convertToGraph();

                    for (Graph graph : graphs) {
                        addToOutputDTO(outputDTO, mapper, graph);
                    }
                }
                    break;
                case 4:
                    System.out.println(mapper.writer().writeValueAsString(outputDTO));
                    break;
                case 5:
                    JsonUtil.writeOutputToJson(outputDTO);
                    System.out.println("Check src/main/resources/ass_3_output.json");
                    return;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    private static void addToOutputDTO(OutputDTO outputDTO, ObjectMapper mapper, Graph graph) throws JsonProcessingException {
        Map.Entry<List<Edge>, Metric> kruskal = graph.kruskalMST();
        Map.Entry<List<Edge>, Metric> prim = graph.primsMST();

        DTOBuilder.addGraphResult(outputDTO,
                graphId++, graph.getEdges().size(),
                graph.getEdges().size(),
                kruskal,
                prim);
    }
}
