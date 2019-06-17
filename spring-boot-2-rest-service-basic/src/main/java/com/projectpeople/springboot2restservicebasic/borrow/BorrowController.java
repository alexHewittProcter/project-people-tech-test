package com.projectpeople.springboot2restservicebasic.borrow;

import com.projectpeople.springboot2restservicebasic.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Used for all the different borrowing functionality, providing urls
 */
@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    /**
     * Used for borrowing functionality, using the borrow service to perform business logic
     * Using the url /borrow/bookId/borrowerId/returnDate with a POST request
     * @param bookId
     * @param borrowerId
     * @param returnDate in the java.util.date format
     * @return A string for the result
     */
    @PostMapping("/borrow/{bookId}/{borrowerId}/{returnDate}")
    public String borrow(@PathVariable int bookId, @PathVariable int borrowerId, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date returnDate) {
        return borrowService.borrow(bookId,borrowerId,returnDate);
    }

    /**
     * Used for the return book functionality using the borrow service business logic
     * Using the url /return/bookId/borrowerId with a POST request
     * @param bookId
     * @param borrowerId
     * @return the Loan object
     */
    @PostMapping("/return/{bookId}/{borrowerId}")
    public Loan returnBook(@PathVariable int bookId, @PathVariable int borrowerId) {
        return borrowService.returnBook(bookId,borrowerId);
    }

    /**
     * Used for viewing all the loans for a specific customer
     * Usinga  GET request at url /customerLoans/id
     * @param id
     * @return a list of loans for the customer
     */
    @GetMapping("/customerLoans/{id}")
    public List<Loan> customerLoans(@PathVariable int id) {
        return borrowService.customerLoans(id);
    }
}
