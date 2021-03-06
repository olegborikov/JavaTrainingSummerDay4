package com.borikov.day4_1.entity;

import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.validator.ArrayValidator;

public class IntegerArray {
    private final int[] numbers;

    public IntegerArray(int[] numbers) throws IncorrectDataException {
        if (numbers == null || numbers.length < 1) {
            throw new IncorrectDataException("incorrect array");
        }
        this.numbers = numbers;
    }

    public int get(int index) throws IncorrectDataException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!(arrayValidator.isIndexCorrect(index, numbers.length))) {
            throw new IncorrectDataException("incorrect array index");
        }
        return numbers[index];
    }

    public void set(int index, int value) throws IncorrectDataException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!(arrayValidator.isIndexCorrect(index, numbers.length))) {
            throw new IncorrectDataException("incorrect array index");
        }
        numbers[index] = value;
    }

    public int size() {
        return numbers.length;
    }

    public boolean equalsToArray(int[] compareNumbers) {
        if (numbers == null) {
            if (compareNumbers != null) {
                return false;
            }
        } else {
            if (compareNumbers == null) {
                return false;
            }
            if (numbers.length != compareNumbers.length) {
                return false;
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] != compareNumbers[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntegerArray integerArray = (IntegerArray) o;
        return equalsToArray(integerArray.numbers);
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int number : numbers) {
            result = 31 * number + result;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntegerArray{");
        sb.append("integerArray=");
        sb.append('[');
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (numbers.length - 1 != i) {
                sb.append(", ");
            }
        }
        sb.append(']');
        sb.append('}');
        return sb.toString();
    }
}
