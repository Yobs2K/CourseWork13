package com.example.coursework13.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_gender")
public class CustomerGender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Integer gender;

    public CustomerGender() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customer_id) {
        this.customerId = customer_id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CustomerGender{" +
                "id=" + id +
                ", customer_id=" + customerId +
                ", gender=" + gender +
                '}';
    }
}
