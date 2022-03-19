package com.example.coursework13.controller;

import com.example.coursework13.io.file.CSVParser;
import com.example.coursework13.repository.CustomerGendersRepository;
import com.example.coursework13.repository.TransactionMccCodesRepository;
import com.example.coursework13.repository.TransactionTypesRepository;
import com.example.coursework13.repository.TransactionsRepository;
import com.example.coursework13.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {


    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping()
    public String getStatsPage() {
        return "upload_page";
    }

    @PostMapping()
    public String uploadCsvFile(@RequestParam("transaction") MultipartFile transactions,
                                @RequestParam("transaction_type") MultipartFile transactionTypes,
                                @RequestParam("mcc_codes") MultipartFile mccCodes,
                                @RequestParam("gender_train") MultipartFile genderTrain
    ) {
        uploadService.deleteAll();
        uploadService.uploadAll(transactions,
                transactionTypes,
                mccCodes,
                genderTrain);

        return "redirect:/stats";
    }


}