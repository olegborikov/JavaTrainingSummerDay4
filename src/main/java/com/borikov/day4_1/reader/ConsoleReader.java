package com.borikov.day4_1.reader;

import com.borikov.day4_1.console.ArrayPrint;
import com.borikov.day4_1.exception.IncorrectDataException;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    public int[] readArraySize(InputStream in) throws IncorrectDataException {
        Scanner scanner = new Scanner(in);
        ArrayPrint arrayPrint = new ArrayPrint();
        try {
            arrayPrint.printEnterSize();
            int size = scanner.nextInt();
            if (size < 1) {
                throw new IncorrectDataException("incorrect array size");
            }
            return new int[size];
        } catch (InputMismatchException e) {
            throw new IncorrectDataException("incorrect input");
        }
    }

    public int readArrayElement(int index, InputStream in)
            throws IncorrectDataException {
        Scanner scanner = new Scanner(in);
        ArrayPrint arrayPrint = new ArrayPrint();
        arrayPrint.printEnterElement(index);
        try {
            int element = scanner.nextInt();
            return element;
        } catch (InputMismatchException e) {
            throw new IncorrectDataException("incorrect input");
        }
    }
}
