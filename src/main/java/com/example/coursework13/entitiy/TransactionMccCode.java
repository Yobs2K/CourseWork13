package com.example.coursework13.entitiy;


import javax.persistence.*;

@Entity
@Table(name = "tr_mcc_codes")
public class TransactionMccCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mcc_code;
    private String mcc_description;

    public TransactionMccCode() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMcc_code() {
        return mcc_code;
    }

    public void setMcc_code(Long mcc_code) {
        this.mcc_code = mcc_code;
    }

    public String getMcc_description() {
        return mcc_description;
    }

    public void setMcc_description(String mcc_description) {
        this.mcc_description = mcc_description;
    }

    @Override
    public String toString() {
        return "TransactionMccCode{" +
                "id=" + id +
                ", mcc_code=" + mcc_code +
                ", mcc_description='" + mcc_description + '\'' +
                '}';
    }
}
