package com.borikov.day4_1.entity;

public class IntegerArray {
    private int[] integerArray;

    public IntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    IntegerArray(int length) {

    }

    public int get(int index) {
        return integerArray[index];
    }

    public void set(int index, int value) {
        integerArray[index] = value;
    }

    public int size() {
        return integerArray.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntegerArray{");
        sb.append("integerArray=");
        sb.append('[');
        for (int i = 0; i < integerArray.length; i++) {
            sb.append(integerArray[i]);
            if (integerArray.length - 1 != i) {
                sb.append(", ");
            }
        }
        sb.append(']');
        sb.append("}");
        return sb.toString();
    }
}
