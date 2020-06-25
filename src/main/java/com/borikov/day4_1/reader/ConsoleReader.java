package com.borikov.day4_1.reader;

import com.borikov.day4_1.console.ArrayPrint;
import com.borikov.day4_1.exception.IncorrectDataException;

import java.util.Scanner;

public class ConsoleReader {
    public int[] readArraySize() throws IncorrectDataException {
        Scanner scanner = new Scanner(System.in);
        ArrayPrint arrayPrint = new ArrayPrint();
        arrayPrint.printEnterSize();
        int size = scanner.nextInt();
        if (size < 1) {
            throw new IncorrectDataException();
        }
        return new int[size];
    }

    public int readArrayElement(int index) throws IncorrectDataException {
        Scanner scanner = new Scanner(System.in);
        ArrayPrint arrayPrint = new ArrayPrint();
        arrayPrint.printEnterElement(index);
        int element = scanner.nextInt();
        return element;
    }
}
