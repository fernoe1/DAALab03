package com.example;

import com.example.DTO.InputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream input = Main.class.getResourceAsStream("/ass_3_input.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        InputDTO graphs = mapper.readValue(input, InputDTO.class);

        System.out.println(mapper.writer().writeValueAsString(graphs));
    }
}