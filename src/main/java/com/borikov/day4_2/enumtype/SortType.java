package com.borikov.day4_2.enumtype;

public enum SortType {
    SUM_LINE {
        public int sortMethod(int[] line) {
            int sum = 0;
            for (int i = 0; i < line.length; i++) {
                sum += line[i];
            }
            return sum;
        }
    },
    MIN_ELEMENT_LINE {
        public int sortMethod(int[] line) {
            int min = line[0];
            for (int i = 1; i < line.length; i++) {
                if (line[i] < min) {
                    min = line[i];
                }
            }
            return min;
        }
    },
    MAX_ELEMENT_LINE {
        public int sortMethod(int[] line) {
            int max = line[0];
            for (int i = 1; i < line.length; i++) {
                if (line[i] > max) {
                    max = line[i];
                }
            }
            return max;
        }
    };

    public abstract int sortMethod(int[] line);
}
