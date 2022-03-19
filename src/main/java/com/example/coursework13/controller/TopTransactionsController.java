package com.example.coursework13.controller;

import com.example.coursework13.dto.Statistic;
import com.example.coursework13.io.file.CSVLocalWriter;
import com.example.coursework13.repository.TransactionsRepository;
import com.example.coursework13.service.StatisticService;
import com.example.coursework13.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final StatsService statsService;
    private final Path statsFilePath = Paths.get("src\\main\\resources\\csvfiles\\top5.csv");

    @Autowired
    public TopTransactionsController(TransactionsRepository transactionsRepository, CSVLocalWriter csvWriter, StatsService statsService) {
        this.transactionsRepository = transactionsRepository;
        this.csvWriter = csvWriter;
        this.statsService = statsService;
    }

    @GetMapping("/top_transactions")
    public ModelAndView getStatsPage() {
        ModelAndView modelAndView = new ModelAndView("top_transactions_page");
        List<Statistic> stats = statsService.getTop(5);
        modelAndView.addObject("stats", stats);
        return modelAndView;
    }
}