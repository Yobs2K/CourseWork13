package com.example.coursework13.entity;

import javax.persistence.*;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;
    private String tr_datetime;
    private Long mcc_code;
    private Long tr_type;
    private Double amount;
    private String term_id;

    public Long getId() {
        return id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public String getTr_datetime() {
        return tr_datetime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public void setTr_datetime(String tr_datetime) {
        this.tr_datetime = tr_datetime;
    }

    public long getMcc_code() {
        return mcc_code;
    }

    public void setMcc_code(long mcc_code) {
        this.mcc_code = mcc_code;
    }

    public long getTr_type() {
        return tr_type;
    }

    public void setTr_type(long tr_type) {
        this.tr_type = tr_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", tr_datetime='" + tr_datetime + '\'' +
                ", mcc_code=" + mcc_code +
                ", tr_type=" + tr_type +
                ", amount=" + amount +
                ", term_id='" + term_id + '\'' +
                '}';
    }
}
