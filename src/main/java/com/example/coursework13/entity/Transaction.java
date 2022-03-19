package com.example.coursework13.entity;

import javax.persistence.*;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String trDatetime;
    private Long mccCode;
    private Long trType;
    private Double amount;
    private String termId;

    public Long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getTrDatetime() {
        return trDatetime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(long customer_id) {
        this.customerId = customer_id;
    }

    public void setTrDatetime(String tr_datetime) {
        this.trDatetime = tr_datetime;
    }

    public long getMccCode() {
        return mccCode;
    }

    public void setMccCode(long mcc_code) {
        this.mccCode = mcc_code;
    }

    public long getTrType() {
        return trType;
    }

    public void setTrType(long tr_type) {
        this.trType = tr_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String term_id) {
        this.termId = term_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customer_id=" + customerId +
                ", tr_datetime='" + trDatetime + '\'' +
                ", mcc_code=" + mccCode +
                ", tr_type=" + trType +
                ", amount=" + amount +
                ", term_id='" + termId + '\'' +
                '}';
    }
}
