package com.projectpeople.springboot2restservicebasic.borrow;

import com.projectpeople.springboot2restservicebasic.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow/{bookId}/{borrowerId}/{returnDate}")
    public String borrow(@PathVariable int bookId, @PathVariable int borrowerId, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date returnDate) {
        return borrowService.borrow(bookId,borrowerId,returnDate);
    }

    @PostMapping("/return/{bookId}/{borrowerId}")
    public Loan returnBook(@PathVariable int bookId, @PathVariable int borrowerId) {
        return borrowService.returnBook(bookId,borrowerId);
    }

    @GetMapping("/customerLoans/{id}")
    public List<Loan> customerLoans(@PathVariable int id) {
        return borrowService.customerLoans(id);
    }
}
