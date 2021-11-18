package com.example.coursework13.exceptions;

public class CsvParseException extends RuntimeException {
    public CsvParseException(String errorMsg) {
        super(errorMsg);
    }
}
