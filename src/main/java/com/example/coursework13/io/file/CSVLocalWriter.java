package com.example.coursework13.io.file;

import com.example.coursework13.entities.Statistic;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

@Component
public class CSVLocalWriter {

    public void writeDataFromEntityListToCsvFile(List<Statistic> entityList, Path path, char separator) throws Exception {
        Writer writer = new FileWriter(path.toString());

        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(separator)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(entityList);
        writer.close();
    }
}
