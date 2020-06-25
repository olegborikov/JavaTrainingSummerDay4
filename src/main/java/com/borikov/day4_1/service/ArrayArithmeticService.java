package com.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;

public class ArrayArithmeticService {
    public final static int MIN_THREE_DIGIT_NUMBER = 100;
    public final static int MAX_THREE_DIGIT_NUMBER = 999;

    public int getMaxValue(IntegerArray integerArray)
            throws IncorrectDataException {
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

    public int getMinValue(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null || integerArray.size() < 1) {
            throw new IncorrectDataException();
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
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberPrime(integerArray.get(i))) {
                size++;
            }
        }
        int[] primeNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberPrime(integerArray.get(i))) {
                primeNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return primeNumbers;
    }

    private boolean isNumberPrime(int number) {
        boolean result = true;
        if (number <= 0) {
            result = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                }
            }
        }
        return result;
    }

    public int[] getFibonacciNumbers(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberFibonacci(integerArray.get(i))) {
                size++;
            }
        }
        int[] fibonacciNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberFibonacci(integerArray.get(i))) {
                fibonacciNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return fibonacciNumbers;
    }

    private boolean isNumberFibonacci(int number) {
        boolean result = false;
        int n2 = 0;
        int n1 = 1;
        int positiveNumber = Math.abs(number);
        while (n2 <= positiveNumber) {
            if (positiveNumber == n1 || positiveNumber == n2) {
                result = true;
                break;
            }
            n2 += n1;
            n1 += n2;
        }
        if (number < 0 && positiveNumber == n1 && number != -1) {
            result = false;
        }
        return result;
    }

    public int[] getThreeDigitUniqueNumbers(IntegerArray integerArray)
            throws IncorrectDataException {
        if (integerArray == null) {
            throw new IncorrectDataException();
        }
        int size = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberThreeDigit(integerArray.get(i))
                    && isNumberUnique(integerArray.get(i))) {
                size++;
            }
        }
        int[] threeDigitUniqueNumbers = new int[size];
        int currentIndex = 0;
        for (int i = 0; i < integerArray.size(); i++) {
            if (isNumberThreeDigit(integerArray.get(i))
                    && isNumberUnique(integerArray.get(i))) {
                threeDigitUniqueNumbers[currentIndex] = integerArray.get(i);
                currentIndex++;
            }
        }
        return threeDigitUniqueNumbers;
    }

    private boolean isNumberThreeDigit(int number) {
        boolean result = false;
        number = Math.abs(number);
        if (number >= MIN_THREE_DIGIT_NUMBER && number <= MAX_THREE_DIGIT_NUMBER) {
            result = true;
        }
        return result;
    }

    private boolean isNumberUnique(int number) {
        boolean result = true;
        number = Math.abs(number);
        int[] numberArray = breakUpNumberToArray(number);
        for (int i = 0; i < numberArray.length - 1; i++) {
            for (int j = i + 1; j < numberArray.length; j++) {
                if (numberArray[i] == numberArray[j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private int[] breakUpNumberToArray(int number) {
        number = Math.abs(number);
        int numberCopy = number;
        int size = 0;
        while (numberCopy > 0) {
            size++;
            numberCopy /= 10;
        }
        int[] numberArray = new int[size];
        int currentIndex = 0;
        while (number > 0) {
            numberArray[currentIndex] = number % 10;
            number /= 10;
            currentIndex++;
        }
        return numberArray;
    }
}
