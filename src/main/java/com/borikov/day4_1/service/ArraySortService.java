package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;

public class ArraySortService {
    public void bubbleSort(IntegerArray integerArray, boolean isReverse) throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        boolean check = true;
        while (check) {
            int lastNumber = 0;
            check = false;
            for (int i = 0; i < (integerArray.size() - 1) - lastNumber; i++) {
                if (integerArray.get(i) > integerArray.get(i + 1)) {
                    swap(integerArray, i, i + 1);
                    check = true;
                }
            }
            lastNumber++;
        }
        if (isReverse) {
            reverse(integerArray);
        }
    }

    public void selectionSort(IntegerArray integerArray, boolean isReverse) throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < integerArray.size(); i++) {
            int minValueIndex = i;
            for (int j = i; j < integerArray.size(); j++) {
                if (integerArray.get(minValueIndex) > integerArray.get(j)) {
                    minValueIndex = j;
                }
            }
            swap(integerArray, i, minValueIndex);
        }
        if (isReverse) {
            reverse(integerArray);
        }
    }

    public void insertionSort(IntegerArray integerArray, boolean isReverse) throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        for (int i = 1; i < integerArray.size(); i++) {
            int current = integerArray.get(i);
            int j = i - 1;
            while (j >= 0 && current < integerArray.get(j)) {
                integerArray.set(j + 1, integerArray.get(j));
                j--;
            }
            integerArray.set(j + 1, current);
        }
        if (isReverse) {
            reverse(integerArray);
        }
    }

    private void swap(IntegerArray integerArray, int firstIndex, int secondIndex) throws IncorrectDataException {
        int firstNumber = integerArray.get(firstIndex);
        int secondNumber = integerArray.get(secondIndex);
        integerArray.set(firstIndex, secondNumber);
        integerArray.set(secondIndex, firstNumber);
    }

    private void reverse(IntegerArray integerArray) throws IncorrectDataException {
        for (int i = 0; i < integerArray.size() / 2; i++) {
            swap(integerArray, i, (integerArray.size() - 1) - i);
        }
    }
}
