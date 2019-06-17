package com.projectpeople.springboot2restservicebasic.borrow;

import com.projectpeople.springboot2restservicebasic.loan.Loan;
import com.projectpeople.springboot2restservicebasic.loan.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImp implements BorrowService{

    @Autowired
    LoanRepository loanRepository;

    @Override
    public String borrow(int bookId, int borrowerId, Date returnDate) {

        List<Loan> loans = loanRepository.findAll();
        for (Loan loan:loans) {
            if(loan.bookId == bookId && loan.returned == false) {
                return "Could not be borrowed, already loaned";
            }
        }
        Loan loan = new Loan();
        loan.bookId = bookId;
        loan.borrowerId = borrowerId;
        loan.borrowDate = new Date();
        loan.returnByDate = returnDate;
        loan.id = loanRepository.count();
        System.out.println(loanRepository.count());
        loanRepository.save(loan);
        return "Borrowed";
    }

    @Override
    public Loan returnBook(int bookId, int borrowerId) {
        List<Loan> loans = loanRepository.findAll();
        for (Loan loan : loans) {
            if(loan.bookId == bookId && loan.borrowerId == borrowerId) {
                loan.returnDate = new Date();
                loan.returned = true;
                loanRepository.save(loan);
                return loan;
            }
        }
        return null;
    }

    @Override
    public List<Loan> customerLoans(int customerId) {
        List<Loan> allLoans = loanRepository.findAll();
        List<Loan> customerLoans = new ArrayList<>();
        for(Loan loan : allLoans) {
            if(loan.borrowerId == customerId && loan.returned == false) {
                customerLoans.add(loan);
            }
        }
        return customerLoans;
    }
}
