package com.example.coursework13.dto;

import com.opencsv.bean.CsvBindByName;

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

    public void setTrType(Long trType) {
        this.trType = trType;
    }

    @Override
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getOccurency() {
        return occurency;
    }

    public void setOccurency(String occurency) {
        this.occurency = occurency;
    }
}
