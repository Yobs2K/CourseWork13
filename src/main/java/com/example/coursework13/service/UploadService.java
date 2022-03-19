package com.example.coursework13.service;

import com.example.coursework13.entity.CustomerGender;
import com.example.coursework13.entity.Transaction;
import com.example.coursework13.entity.TransactionMccCode;
import com.example.coursework13.entity.TransactionType;
import com.example.coursework13.io.file.CSVParser;
import com.example.coursework13.repository.CustomerGendersRepository;
import com.example.coursework13.repository.TransactionMccCodesRepository;
import com.example.coursework13.repository.TransactionTypesRepository;
import com.example.coursework13.repository.TransactionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UploadService {
    private final CSVParser csvParser;

    private final TransactionsRepository transactionsRepository;
    private final TransactionTypesRepository transactionTypesRepository;
    private final TransactionMccCodesRepository transactionMccCodesRepository;
    private final CustomerGendersRepository customerGendersRepository;

    public UploadService(CSVParser csvParser,
                         TransactionsRepository transactionsRepository,
                         TransactionTypesRepository transactionTypesRepository,
                         TransactionMccCodesRepository transactionMccCodesRepository,
                         CustomerGendersRepository customerGendersRepository
    ) {
        this.csvParser = csvParser;
        this.transactionsRepository = transactionsRepository;
        this.transactionTypesRepository = transactionTypesRepository;
        this.transactionMccCodesRepository = transactionMccCodesRepository;
        this.customerGendersRepository = customerGendersRepository;
    }

    public void deleteAll() {
        transactionsRepository.deleteAll();
        transactionTypesRepository.deleteAll();
        transactionMccCodesRepository.deleteAll();
        customerGendersRepository.deleteAll();
    }

    public void uploadAll(MultipartFile transactions,
                          MultipartFile transactionTypes,
                          MultipartFile mccCodes,
                          MultipartFile genderTrain
    ) {
        List<Transaction> transactionList = csvParser
                .parseDataFromCsvFileToEntityList(transactions, Transaction.class, ',');
        transactionsRepository.saveAll(transactionList);

        List<TransactionType> transactionTypeList = csvParser.
                parseDataFromCsvFileToEntityList(transactionTypes, TransactionType.class, ';');
        transactionTypesRepository.saveAll(transactionTypeList);

        List<TransactionMccCode> transactionMccCodeList = csvParser.
                parseDataFromCsvFileToEntityList(mccCodes, TransactionMccCode.class, ';');
        transactionMccCodesRepository.saveAll(transactionMccCodeList);

        List<CustomerGender> customerGenderList = csvParser.
                parseDataFromCsvFileToEntityList(genderTrain, CustomerGender.class, ',');
        customerGendersRepository.saveAll(customerGenderList);
    }
}