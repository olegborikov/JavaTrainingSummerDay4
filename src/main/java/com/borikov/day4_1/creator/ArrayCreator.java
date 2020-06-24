package com.borikov.day4_1.creator;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayCreator {
    public static final int MAX_RANDOM = 1000;
    public static final int MIN_RANDOM = -1000;

    public IntegerArray createAndFillArrayRandom(int size) throws IncorrectDataException {
        if (size < 1) {
            throw new IncorrectDataException();
        }
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
        }
        return new IntegerArray(numbers);
    }

    public IntegerArray createAndFillArrayConsole() throws IncorrectDataException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter array size: ");
        int size = scanner.nextInt();
        if (size < 1) {
            throw new IncorrectDataException();
        }
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Enter %d element: ", i);
            numbers[i] = scanner.nextInt();
        }
        return new IntegerArray(numbers);
    }

    public IntegerArray createAndFillArrayFile() throws IncorrectDataException {
        Path path = Paths.get("src\\main\\resources\\data\\data.txt");
        List<String> dataLines = null;
        String numberLine = null;
        try {
            dataLines = Files.readAllLines(path);
            numberLine = dataLines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] a = numberLine.trim().split("\\s");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        return new IntegerArray(arr);
    }
}
