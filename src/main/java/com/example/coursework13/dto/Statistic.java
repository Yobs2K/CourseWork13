package com.example.coursework13.dto;

import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Statistic implements StatisticView {

    @CsvBindByName(column = "tr_type")
    private Long trType;
    @CsvBindByName(column = "quantity")
    private Long quantity;
    @CsvBindByName(column = "occurency")
    private String occurency;

    public Statistic() {

    }

    public Statistic(Long trType, Long quantity, String occurency) {
        this.trType = trType;
        this.quantity = quantity;
        this.occurency = occurency;
    }

    @Override
    public Long getTrType() {
        return trType;
    }

    @Override
    public Long getQuantity() {
        return quantity;
    }

    @Override
    public String getOccurency() {
        return occurency;
    }

    public void setTrType(Long trType) {
        this.trType = trType;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setOccurency(String occurency) {
        this.occurency = occurency;
    }

    public static List<Statistic> getStatisticListFromViewList (List<StatisticView> statisticViewList) {
        List <Statistic> statisticList = new ArrayList<Statistic>();

        statisticViewList.forEach(x -> statisticList.add(new Statistic(x.getTrType(), x.getQuantity(), x.getOccurency())));
        return statisticList;
    }
}
