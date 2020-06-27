package com.borikov.day4_1.creator;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.parser.ArrayParser;
import com.borikov.day4_1.reader.ConsoleReader;
import com.borikov.day4_1.reader.CustomFileReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

public class ArrayCreator {
    private static final int MAX_RANDOM = 1000;
    private static final int MIN_RANDOM = -1000;
    private static final String sizeData = "10";
    private static final String[] elementData = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public IntegerArray createAndFillArrayRandom(int size)
            throws IncorrectDataException {
        if (size < 1) {
            throw new IncorrectDataException("incorrect array size");
        }
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
        }
        return new IntegerArray(numbers);
    }

    public IntegerArray createAndFillArrayConsole()
            throws IncorrectDataException {
        ConsoleReader consoleReader = new ConsoleReader();
        InputStream size = new ByteArrayInputStream(sizeData.getBytes());
        int[] numbers = consoleReader.readArraySize(size);
        InputStream element;
        for (int i = 0; i < numbers.length; i++) {
            element = new ByteArrayInputStream(elementData[i].getBytes());
            numbers[i] = consoleReader.readArrayElement(i, element);
        }
        return new IntegerArray(numbers);
    }

    public IntegerArray createAndFillArrayFile(String file)
            throws IncorrectDataException {
        CustomFileReader customFileReader = new CustomFileReader();
        ArrayParser arrayParser = new ArrayParser();
        String data = customFileReader.readArray(file);
        int[] numbers = arrayParser.parseLineToArray(data);
        return new IntegerArray(numbers);
    }
}
