package com.example.coursework13.controllers;

import com.example.coursework13.entities.Statistic;
import com.example.coursework13.io.file.CSVLocalWriter;
import com.example.coursework13.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class TopTransactionsController {


    private final TransactionsRepository transactionsRepository;
    private final CSVLocalWriter csvWriter;
    private final Path statsFilePath = Paths.get("src\\main\\resources\\csvfiles\\top5.csv");

    @Autowired
    public TopTransactionsController(TransactionsRepository transactionsRepository, CSVLocalWriter csvWriter) {
        this.transactionsRepository = transactionsRepository;
        this.csvWriter = csvWriter;
    }

    @GetMapping("/top_transactions")
    public ModelAndView getStatsPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView("top_transactions_page");
        List<Statistic> stats = Statistic.getStatisticListFromViewList(transactionsRepository.calculateStatistics());
        stats.forEach(
                x->System.out.printf("%s, %s, %s\n",x.getTrType(), x.getQuantity(), x.getOccurency())
        );
        stats = stats.subList(0,5);
        modelAndView.addObject("stats", stats);

        csvWriter.writeDataFromEntityListToCsvFile(stats, statsFilePath, ',');

        return modelAndView;
    }
}
