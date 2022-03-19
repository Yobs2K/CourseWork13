package com.example.coursework13.controller;

import com.example.coursework13.dto.Statistic;
import com.example.coursework13.io.file.CSVLocalWriter;
import com.example.coursework13.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class StatsController {

    private final TransactionsRepository transactionsRepository;
    private final CSVLocalWriter csvWriter;
    private final Path statsFilePath = Paths.get("src\\main\\resources\\csvfiles\\stats.csv");

    @Autowired
    public StatsController(TransactionsRepository transactionsRepository, CSVLocalWriter csvWriter) {
        this.transactionsRepository = transactionsRepository;
        this.csvWriter = csvWriter;
    }

    @GetMapping("/stats")
    public ModelAndView getStatsPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView("stats_page");
        List<Statistic> stats;
        stats = Statistic.getStatisticListFromViewList(transactionsRepository.calculateStatistics());
        stats.forEach(
                x->System.out.printf("%s, %s, %s\n",x.getTrType(), x.getQuantity(), x.getOccurency())
        );
        modelAndView.addObject("stats", stats);

        csvWriter.writeDataFromEntityListToCsvFile(stats, statsFilePath, ',');

        return modelAndView;
    }
}
