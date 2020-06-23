package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;

public class IntegerArrayService {
    public void bubbleSort(IntegerArray integerArray, boolean reverse) throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        boolean check = true;
        while (check) {
            check = false;
            for (int i = 0; i < integerArray.size() - 1; i++) {
                if (integerArray.get(i) > integerArray.get(i + 1)) {
                    swap(integerArray, i, i + 1);
                    check = true;
                }
            }
        }
        if (reverse) {
            reverse(integerArray);
        }
    }

    private void swap(IntegerArray integerArray, int firstIndex, int secondIndex) {
        int firstNumber = integerArray.get(firstIndex);
        int secondNumber = integerArray.get(secondIndex);
        integerArray.set(firstIndex, secondNumber);
        integerArray.set(secondIndex, firstNumber);
    }

    private void reverse(IntegerArray integerArray) {
        for (int i = 0; i < integerArray.size() / 2; i++) {
            swap(integerArray, i, (integerArray.size() - 1) - i);
        }
    }
}
