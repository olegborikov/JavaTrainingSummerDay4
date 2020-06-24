package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;

public class ArrayArithmeticService {
    public int getMaxValue(IntegerArray integerArray) throws IncorrectDataException {
        if (integerArray == null || integerArray.size() < 1) {
            throw new IncorrectDataException();
        }
        int maxValue = integerArray.get(0);
        for (int i = 0; i < integerArray.size(); i++) {
            if (maxValue < integerArray.get(i)) {
                maxValue = integerArray.get(i);
            }
        }
        return maxValue;
    }

    public int getMinValue(IntegerArray integerArray) throws IncorrectDataException {
        if (integerArray == null || integerArray.size() < 1) {
            throw new IncorrectDataException();
        }
        int maxValue = integerArray.get(0);
        for (int i = 0; i < integerArray.size(); i++) {
            if (maxValue > integerArray.get(i)) {
                maxValue = integerArray.get(i);
            }
        }
        return maxValue;
    }
}
