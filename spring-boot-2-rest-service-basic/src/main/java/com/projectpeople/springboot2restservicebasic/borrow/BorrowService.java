package com.projectpeople.springboot2restservicebasic.borrow;

import com.projectpeople.springboot2restservicebasic.loan.Loan;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    public abstract String borrow(int bookId, int borrowerId, Date returnDate);
    public abstract Loan returnBook(int bookId,int borrowerId);
    public abstract List<Loan> customerLoans(int customerId);
}
