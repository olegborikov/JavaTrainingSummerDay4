package com.borikov.day4_1.parser;

import com.borikov.day4_1.exception.IncorrectDataException;

public class ArrayParser {

    public int[] parseLineToArray(String data) throws IncorrectDataException {
        if (data == null || data.equals("")) {
            throw new IncorrectDataException();
        }
        try {
            data = data.replaceAll("[\\s]{2,}", " ");
            String[] a = data.trim().split("\\s");
            int[] numbers = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                numbers[i] = Integer.parseInt(a[i]);
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IncorrectDataException();
        }
    }

    public int[] breakUpNumberToArray(int number) {
        number = Math.abs(number);
        int numberCopy = number;
        int size = 0;
        while (numberCopy > 0) {
            size++;
            numberCopy /= 10;
        }
        if (size == 0) {
            size++;
        }
        int[] numberArray = new int[size];
        int currentIndex = size - 1;
        while (number > 0) {
            numberArray[currentIndex] = number % 10;
            number /= 10;
            currentIndex--;
        }
        return numberArray;
    }
}
