package com.borikov.day4_2.validator;

public class JaggedArrayValidator {
    private static final int MIN_INDEX = 0;

    public boolean isIndexCorrect(int index, int length) {
        boolean result = false;
        if (index >= MIN_INDEX && index < length) {
            result = true;
        }
        return result;
    }
}
