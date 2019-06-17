package com.projectpeople.springboot2restservicebasic.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    @Autowired private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/{id}")
    public Loan getLoan(@PathVariable Long id) {
        Optional<Loan> loan = loanRepository.findById(id);
        return loan.get();
    }

    @DeleteMapping("/loans/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanRepository.deleteById(id);
    }

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan) {
        Loan savedLoan = loanRepository.save(loan);
        return savedLoan;
    }

    @PutMapping("/loans/{id}")
    public Loan updateLoan(@RequestBody Loan loan, @PathVariable Long id) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        if(loanOptional.isPresent()) {
            loan.id = id;
            loanRepository.save(loan);
            return loan;
        } else {
            return null;
        }
    }

}
