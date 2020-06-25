package com.borikov.day4_1.parser;

public class ArrayParser {
    public int[] parseLineToArray(String data) {
        String[] a = data.trim().split("\\s");
        int[] numbers = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            numbers[i] = Integer.parseInt(a[i]);
        }
        return numbers;
    }
}
