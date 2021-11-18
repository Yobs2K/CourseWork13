package com.example.coursework13.controllers;

import com.example.coursework13.entities.CustomerGender;
import com.example.coursework13.entities.Transaction;
import com.example.coursework13.entities.TransactionMccCode;
import com.example.coursework13.entities.TransactionType;
import com.example.coursework13.io.file.CSVParser;
import com.example.coursework13.repositories.CustomerGendersRepository;
import com.example.coursework13.repositories.TransactionMccCodesRepository;
import com.example.coursework13.repositories.TransactionTypesRepository;
import com.example.coursework13.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {


    private final CSVParser csvParser;

    private final TransactionsRepository transactionsRepository;
    private final TransactionTypesRepository transactionTypesRepository;
    private final TransactionMccCodesRepository transactionMccCodesRepository;
    private final CustomerGendersRepository customerGendersRepository;

    @Autowired
    public UploadController(CSVParser csvParser, TransactionsRepository transactionsRepository, TransactionTypesRepository transactionTypesRepository, TransactionMccCodesRepository transactionMccCodesRepository, CustomerGendersRepository customerGendersRepository) {
        this.csvParser = csvParser;
        this.transactionsRepository = transactionsRepository;
        this.transactionTypesRepository = transactionTypesRepository;
        this.transactionMccCodesRepository = transactionMccCodesRepository;
        this.customerGendersRepository = customerGendersRepository;
    }

    @GetMapping()
    public String getStatsPage() {
        return "upload_page";
    }

    @PostMapping()
    public String uploadCsvFile(@RequestParam("transaction") MultipartFile transactions,
                                @RequestParam("transaction_type") MultipartFile transactionTypes,
                                @RequestParam("mcc_codes") MultipartFile mccCodes,
                                @RequestParam("gender_train") MultipartFile genderTrain) {



        transactionsRepository.deleteAll();
        List<Transaction> transactionList = csvParser
                .parseDataFromCsvFileToEntityList(transactions, Transaction.class, ',');
        transactionsRepository.saveAll(transactionList);

        transactionTypesRepository.deleteAll();
        List<TransactionType> transactionTypeList = csvParser.
                parseDataFromCsvFileToEntityList(transactionTypes, TransactionType.class, ';');
        transactionTypesRepository.saveAll(transactionTypeList);

        transactionMccCodesRepository.deleteAll();
        List<TransactionMccCode> transactionMccCodeList = csvParser.
                parseDataFromCsvFileToEntityList(mccCodes, TransactionMccCode.class, ';');
        transactionMccCodesRepository.saveAll(transactionMccCodeList);

        customerGendersRepository.deleteAll();
        List<CustomerGender> customerGenderList = csvParser.
                parseDataFromCsvFileToEntityList(genderTrain, CustomerGender.class, ',');
        customerGendersRepository.saveAll(customerGenderList);

        return "redirect:/stats";
    }


}
