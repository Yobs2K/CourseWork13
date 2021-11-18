package com.example.coursework13.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer_gender")
public class CustomerGender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;
    private Integer gender;

    public CustomerGender() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
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
                ", customer_id=" + customer_id +
                ", gender=" + gender +
                '}';
    }
}
