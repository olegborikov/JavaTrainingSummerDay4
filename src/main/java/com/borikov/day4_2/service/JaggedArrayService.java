package com.borikov.day4_2.service;

import com.borikov.day4_2.enumtype.SortType;
import com.borikov.day4_2.exception.IncorrectDataException;

public class JaggedArrayService {
    public void bubbleSort(int[][] numbers, SortType sortType, boolean isReverse) throws IncorrectDataException {
        if (numbers == null) {
            throw new IncorrectDataException();
        }
        boolean check = true;
        while (check) {
            int lastNumber = 0;
            check = false;
            for (int i = 0; i < (numbers.length - 1) - lastNumber; i++) {
                if (sortType.sortMethod(numbers[i]) > sortType.sortMethod(numbers[i + 1])) {
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

    private void swapLines(int[][] numbers, int firstIndex, int secondIndex) {
        int[] firstNumber = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = firstNumber;
    }

    private void reverseLines(int[][] numbers) throws IncorrectDataException {
        if (numbers == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            swapLines(numbers, i, (numbers.length - 1) - i);
        }
    }

    public int max() {
        return 1;
    }
}
