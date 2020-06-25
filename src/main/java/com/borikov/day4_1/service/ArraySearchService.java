package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.validator.ArrayValidator;

public class ArraySearchService {
    public int binarySearch(IntegerArray integerArray,
                            int number) throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        ArraySortService arraySortService = new ArraySortService();
        arraySortService.bubbleSort(integerArray, false);
        int position = -1;
        int firstIndex = 0;
        int lastIndex = integerArray.size() - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (integerArray.get(middleIndex) == number) {
                position = middleIndex;
                break;
            } else if (integerArray.get(middleIndex) < number) {
                firstIndex = middleIndex + 1;
            } else if (integerArray.get(middleIndex) > number) {
                lastIndex = middleIndex - 1;
            }
        }
        return position;
    }
}
