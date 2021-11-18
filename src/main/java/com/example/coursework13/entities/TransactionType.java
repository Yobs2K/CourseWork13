package com.example.coursework13.entities;

import javax.persistence.*;

@Entity
@Table(name = "transactions_types")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tr_type;
    private String tr_description;

    public TransactionType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTr_type() {
        return tr_type;
    }

    public void setTr_type(Long tr_type) {
        this.tr_type = tr_type;
    }

    public String getTr_description() {
        return tr_description;
    }

    public void setTr_description(String tr_description) {
        this.tr_description = tr_description;
    }


    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", tr_type=" + tr_type +
                ", tr_description='" + tr_description + '\'' +
                '}';
    }
}
