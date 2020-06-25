package com.borikov.day4_1.reader;

import com.borikov.day4_1.exception.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    private static final String DEFAULT_PATH = "src\\main\\resources\\data\\data.txt";

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
            return data;
        } catch (IOException e) {
            throw new IncorrectDataException();
        }
    }
}
