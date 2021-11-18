package com.example.coursework13.repositories;

import com.example.coursework13.entities.CustomerGender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerGendersRepository extends JpaRepository<CustomerGender, Long> {

}
