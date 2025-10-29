package com.example.util;

import com.example.DTO.OutputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonUtil {

    /**
     * Writes the given OutputDTO object to a JSON file named
     * 'ass_3_output.json' inside the resources directory.
     * @param outputDTO the data to write to JSON.
     */
    public static void writeOutputToJson(OutputDTO outputDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            Path path = Path.of("src", "main", "resources", "ass_3_output.json");

            Files.createDirectories(path.getParent());

            File outputFile = path.toFile();

            mapper.writeValue(outputFile, outputDTO);

            System.out.println("JSON written successfully to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write JSON: " + e.getMessage());
        }
    }
}
