package com.projectpeople.springboot2restservicebasic.loan;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A repository extension used specifically for Loans of books
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
