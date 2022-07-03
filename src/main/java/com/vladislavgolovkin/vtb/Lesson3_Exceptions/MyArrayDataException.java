package com.vladislavgolovkin.vtb.Lesson3_Exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }
}
