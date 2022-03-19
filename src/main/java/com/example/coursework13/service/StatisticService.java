package com.example.coursework13.service;

import com.example.coursework13.dto.Statistic;
import com.example.coursework13.dto.StatisticView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {
    public List<Statistic> getStatisticListFromViewList(List<StatisticView> statisticViewList) {
        List<Statistic> statisticList = new ArrayList<>();

        statisticViewList.forEach(x -> statisticList.add(new Statistic(x.getTrType(), x.getQuantity(), x.getOccurency())));
        return statisticList;
    }
}