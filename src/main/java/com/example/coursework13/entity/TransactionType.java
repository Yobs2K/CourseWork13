package com.example.coursework13.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions_types")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trType;
    private String trDescription;

    public TransactionType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrType() {
        return trType;
    }

    public void setTrType(Long tr_type) {
        this.trType = tr_type;
    }

    public String getTrDescription() {
        return trDescription;
    }

    public void setTrDescription(String tr_description) {
        this.trDescription = tr_description;
    }


    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", tr_type=" + trType +
                ", tr_description='" + trDescription + '\'' +
                '}';
    }
}
