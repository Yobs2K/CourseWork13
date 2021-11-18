package com.example.coursework13.io.file;

import com.example.coursework13.exceptions.CsvParseException;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class CSVParser {

    public  <T> List<T> parseDataFromCsvFileToEntityList(MultipartFile file, Class<T> tClass, char separator) {
        List<T> beans;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBeanBuilder builder = new CsvToBeanBuilder(reader).withType(tClass);
            builder.withSeparator(separator);
            beans = builder.build()
                    .parse();
        } catch (RuntimeException | IOException e) {
            throw new CsvParseException("Something went wrong." +
                    "\nThe reason: " + e.getMessage());
        }
        return beans;
    }




}
