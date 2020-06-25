package com.borikov.day4_1.creator;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.parser.ArrayParser;
import com.borikov.day4_1.reader.ConsoleReader;
import com.borikov.day4_1.reader.FileReader;

import java.util.Random;

public class ArrayCreator {
    private static final int MAX_RANDOM = 1000;
    private static final int MIN_RANDOM = -1000;

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
        ConsoleReader consoleReader = new ConsoleReader();
        int[] numbers = consoleReader.readArraySize();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = consoleReader.readArrayElement(i);
        }
        return new IntegerArray(numbers);
    }

    public IntegerArray createAndFillArrayFile(String file) throws IncorrectDataException {
        FileReader fileReader = new FileReader();
        ArrayParser arrayParser = new ArrayParser();
        String data = fileReader.readArray(file);
        int[] numbers = arrayParser.parseLineToArray(data);
        return new IntegerArray(numbers);
    }
}
