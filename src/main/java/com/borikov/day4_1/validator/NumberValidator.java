package com.borikov.day4_1.validator;

import com.borikov.day4_1.parser.ArrayParser;

public class NumberValidator {
    public static final int MIN_THREE_DIGIT_NUMBER = 100;
    public static final int MAX_THREE_DIGIT_NUMBER = 999;

    public boolean isNumberPrime(int number) {
        boolean result = true;
        if (number <= 0) {
            result = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isNumberFibonacci(int number) {
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

    public boolean isNumberThreeDigit(int number) {
        boolean result = false;
        number = Math.abs(number);
        if (number >= MIN_THREE_DIGIT_NUMBER && number <= MAX_THREE_DIGIT_NUMBER) {
            result = true;
        }
        return result;
    }

    public boolean isNumberUnique(int number) {
        boolean result = true;
        number = Math.abs(number);
        ArrayParser arrayParser = new ArrayParser();
        int[] numberArray = arrayParser.breakUpNumberToArray(number);
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
}

