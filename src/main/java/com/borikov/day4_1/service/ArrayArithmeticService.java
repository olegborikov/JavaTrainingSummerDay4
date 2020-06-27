package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.validator.NumberValidator;

public class ArrayArithmeticService {
    public int maxValue(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null || integerArray.size() < 1) {
            throw new IncorrectDataException("incorrect array");
        }
        int maxValue = integerArray.get(0);
        for (int i = 0; i < integerArray.size(); i++) {
            if (maxValue < integerArray.get(i)) {
                maxValue = integerArray.get(i);
            }
        }
        return maxValue;
    }

    public int minValue(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null || integerArray.size() < 1) {
            throw new IncorrectDataException("incorrect array");
        }
        int minValue = integerArray.get(0);
        for (int i = 0; i < integerArray.size(); i++) {
            if (minValue > integerArray.get(i)) {
                minValue = integerArray.get(i);
            }
        }
        return minValue;
    }

    public int[] getPrimeNumbers(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        NumberValidator numberValidator = new NumberValidator();
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberPrime(integerArray.get(i))) {
                size++;
            }
        }
        int[] primeNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberPrime(integerArray.get(i))) {
                primeNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return primeNumbers;
    }

    public int[] getFibonacciNumbers(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        NumberValidator numberValidator = new NumberValidator();
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberFibonacci(integerArray.get(i))) {
                size++;
            }
        }
        int[] fibonacciNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberFibonacci(integerArray.get(i))) {
                fibonacciNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return fibonacciNumbers;
    }

    public int[] getThreeDigitUniqueNumbers(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        NumberValidator numberValidator = new NumberValidator();
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberThreeDigit(integerArray.get(i))
                    && numberValidator.isNumberUnique(integerArray.get(i))) {
                size++;
            }
        }
        int[] threeDigitUniqueNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (numberValidator.isNumberThreeDigit(integerArray.get(i))
                    && numberValidator.isNumberUnique(integerArray.get(i))) {
                threeDigitUniqueNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return threeDigitUniqueNumbers;
    }
}
