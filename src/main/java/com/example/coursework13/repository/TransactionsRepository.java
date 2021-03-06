package com.example.coursework13.repository;

import com.example.coursework13.dto.StatisticView;
import com.example.coursework13.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "" +
            "select " +
            "  trType as trType, " +
            "  count(trType) as quantity, " +
            "  concat(" +
            "    round(" +
            "      (cast(count(tr_type) as float))/(select count (*) from transactions)*1000)" +
            "    /10," +
            "    '%')" +
            "  as occurency from transactions\n" +
            "group by trType\n" +
            "order by quantity desc")
    List<StatisticView> calculateStatistics();

}