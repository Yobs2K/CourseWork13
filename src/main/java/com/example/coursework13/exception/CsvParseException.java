package com.example.coursework13.exception;

public class CsvParseException extends RuntimeException {
    public CsvParseException(String errorMsg) {
        super(errorMsg);
    }
}
