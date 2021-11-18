package com.example.coursework13.repositories;

import com.example.coursework13.entities.Transaction;
import com.example.coursework13.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionType, Long> {

}
