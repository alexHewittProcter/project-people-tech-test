package com.projectpeople.springboot2restservicebasic.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The loan controller is used to provide all the CRUD services for loans
 */
@RestController
public class LoanController {

    @Autowired private LoanRepository loanRepository;

    /**
     * Used to show all loans stored
     * Using the url /loans
     * @return list of loans
     */
    @GetMapping("/loans")
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    /**
     * Gets a specific loan based on the id provided
     * Accessed using /loans/id
     * @param id
     * @return a loan object
     */
    @GetMapping("/loans/{id}")
    public Loan getLoan(@PathVariable Long id) {
        Optional<Loan> loan = loanRepository.findById(id);
        return loan.get();
    }

    /**
     * Deletes a specific loan from the database using a specific id
     * Uses a DELETE request at the url /loans/id
     * @param id
     */
    @DeleteMapping("/loans/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanRepository.deleteById(id);
    }

    /**
     * Adds a loan to the database store using a POST request
     * At the /loans url
     * @param loan
     * @return the created loan object
     */
    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan) {
        Loan savedLoan = loanRepository.save(loan);
        return savedLoan;
    }

    /**
     * Updates a loan based on a specific id
     * Uses a PUT request with the url /loans/id
     * @param loan
     * @param id
     * @return the updated loan
     */
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
