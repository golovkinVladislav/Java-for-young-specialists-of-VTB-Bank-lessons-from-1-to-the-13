package com.vladislavgolovkin.vtb.Lesson3_Exceptions;
/* Практическое задание
1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
MyArrayDataException (в ячейке массива лежит что-то не то);
2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером
4×4. При подаче массива другого размера необходимо бросить исключение
MyArraySizeException.
3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
данных для этой матрицы прекращается.
4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException и вывести результат расчёта  */
public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] strings = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}, {"1","2","3","4"}};
        System.out.println(WorkWithArray.checkSizeArrayAndSumElementsArray(strings));
    }
}
