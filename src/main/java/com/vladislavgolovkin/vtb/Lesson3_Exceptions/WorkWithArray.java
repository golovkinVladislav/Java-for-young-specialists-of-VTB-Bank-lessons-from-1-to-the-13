package com.vladislavgolovkin.vtb.Lesson3_Exceptions;

public class WorkWithArray {
    private static final int row = 4;
    private static final int column = 4;
    private static int sum = 0;

    public static int checkSizeArrayAndSumElementsArray(String[][] strings) {
        if (strings.length != row) {
            throw new MyArraySizeException("Размер матрицы должен быть 4х4");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != column) {
                throw new MyArraySizeException("Размер матрицы должен быть 4х4");
            }
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.valueOf(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке " + "[" + i + "]" + "[" + j + "]"
                            + " должно лежать число. " + " Расчет данных прекратился, сумма = " + sum);
                }
            }
        }
        return sum;
    }
}


