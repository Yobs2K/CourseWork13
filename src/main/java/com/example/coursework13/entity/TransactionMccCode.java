package com.example.coursework13.entity;


import javax.persistence.*;

@Entity
@Table(name = "tr_mcc_codes")
public class TransactionMccCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mccCode;
    private String mccDescription;

    public TransactionMccCode() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMccCode() {
        return mccCode;
    }

    public void setMccCode(Long mcc_code) {
        this.mccCode = mcc_code;
    }

    public String getMccDescription() {
        return mccDescription;
    }

    public void setMccDescription(String mcc_description) {
        this.mccDescription = mcc_description;
    }

    @Override
    public String toString() {
        return "TransactionMccCode{" +
                "id=" + id +
                ", mcc_code=" + mccCode +
                ", mcc_description='" + mccDescription + '\'' +
                '}';
    }
}
