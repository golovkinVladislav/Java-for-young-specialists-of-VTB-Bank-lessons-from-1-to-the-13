package com.vladislavgolovkin.vtb.Lesson3_Exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String message) {
        super(message);
    }
}
