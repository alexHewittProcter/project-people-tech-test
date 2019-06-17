package com.projectpeople.springboot2restservicebasic.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loan")
    private List<Loan> index() {
        return loanRepository.findAll();
    }
}
