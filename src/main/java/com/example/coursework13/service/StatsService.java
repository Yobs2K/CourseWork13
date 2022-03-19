package com.example.coursework13.service;

import com.example.coursework13.dto.Statistic;
import com.example.coursework13.io.file.CSVLocalWriter;
import com.example.coursework13.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StatsService {

    private final TransactionsRepository transactionsRepository;
    private final CSVLocalWriter csvWriter;
    private final StatisticService statisticService;
    private final Path statsFilePath = Paths.get("src\\main\\resources\\csvfiles\\stats.csv");
    private final Path topFilePath = Paths.get("src\\main\\resources\\csvfiles\\top5.csv");

    @Autowired
    public StatsService(TransactionsRepository transactionsRepository, CSVLocalWriter csvWriter, StatisticService statisticService) {
        this.transactionsRepository = transactionsRepository;
        this.csvWriter = csvWriter;
        this.statisticService = statisticService;
    }


    public List<Statistic> getAllStats() {
        List<Statistic> stats;
        stats = statisticService.getStatisticListFromViewList(transactionsRepository.calculateStatistics());
        stats.forEach(
                x -> System.out.printf("%s, %s, %s\n", x.getTrType(), x.getQuantity(), x.getOccurency())
        );
        try {
            csvWriter.writeDataFromEntityListToCsvFile(stats, statsFilePath, ',');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return stats;
    }

    public List<Statistic> getTop(int topNum) {
        List<Statistic> stats;
        stats = statisticService.getStatisticListFromViewList(transactionsRepository.calculateStatistics());
        stats.forEach(
                x -> System.out.printf("%s, %s, %s\n", x.getTrType(), x.getQuantity(), x.getOccurency())
        );
        stats = stats.subList(0, topNum);
        try {
            csvWriter.writeDataFromEntityListToCsvFile(stats, topFilePath, ',');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return stats;
    }
}