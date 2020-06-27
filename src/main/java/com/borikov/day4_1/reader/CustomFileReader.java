package com.borikov.day4_1.reader;

import com.borikov.day4_1.exception.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private static final String DEFAULT_PATH = "input/defaultData.txt";

    public String readArray(String file) throws IncorrectDataException {
        Path path = Paths.get(DEFAULT_PATH);
        if (file != null) {
            path = Paths.get(file);
            if (Files.notExists(path)) {
                path = Paths.get(DEFAULT_PATH);
            }
        }
        try {
            String data = Files.readAllLines(path).get(0);
            System.out.println("123");
            return data;
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new IncorrectDataException();
        }
    }
}
