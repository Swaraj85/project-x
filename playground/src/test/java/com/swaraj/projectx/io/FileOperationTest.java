package com.swaraj.projectx.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOperationTest {

    private String folderpath = "C:\\projects\\microservice\\project-x\\data\\";

    @Test
    void readFileInStream() throws IOException {
        Stream<String> lines;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(folderpath + "crunched-data.csv"))) {
            lines = bufferedReader.lines();
            lines.forEach(s -> System.out.println("s = " + s));
        }
    }
}
