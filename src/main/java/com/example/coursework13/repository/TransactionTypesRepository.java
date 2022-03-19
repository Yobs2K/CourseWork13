package com.example.coursework13.repository;

import com.example.coursework13.entitiy.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionType, Long> {

}
