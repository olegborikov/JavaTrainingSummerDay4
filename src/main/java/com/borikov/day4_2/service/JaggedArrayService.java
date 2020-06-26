package com.borikov.day4_2.service;

import com.borikov.day4_2.type.SortType;
import com.borikov.day4_2.exception.InvalidDataException;
import com.borikov.day4_2.validator.JaggedArrayValidator;

public class JaggedArrayService {
    public void bubbleSort(int[][] numbers,
                           SortType sortType,
                           boolean isReverse) throws InvalidDataException {
        if (numbers == null || sortType == null) {
            throw new InvalidDataException();
        }
        boolean check = true;
        while (check) {
            int lastNumber = 0;
            check = false;
            for (int i = 0; i < (numbers.length - 1) - lastNumber; i++) {
                if (sortType.sortMethod(numbers[i]) >
                        sortType.sortMethod(numbers[i + 1])) {
                    swapLines(numbers, i, i + 1);
                    check = true;
                }
            }
            lastNumber++;
        }
        if (isReverse) {
            reverseLines(numbers);
        }
    }

    private void swapLines(int[][] numbers,
                           int firstIndex,
                           int secondIndex) throws InvalidDataException {
        JaggedArrayValidator jaggedArrayValidator = new JaggedArrayValidator();
        if (numbers == null
                || !(jaggedArrayValidator.isIndexCorrect(firstIndex, numbers.length))
                || !(jaggedArrayValidator.isIndexCorrect(secondIndex, numbers.length))) {
            throw new InvalidDataException();
        }
        int[] firstNumber = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = firstNumber;
    }

    private void reverseLines(int[][] numbers) throws InvalidDataException {
        if (numbers == null) {
            throw new InvalidDataException();
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            swapLines(numbers, i, (numbers.length - 1) - i);
        }
    }
}
