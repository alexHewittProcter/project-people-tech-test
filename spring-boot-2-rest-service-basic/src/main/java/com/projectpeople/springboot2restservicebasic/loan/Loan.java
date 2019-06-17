package com.projectpeople.springboot2restservicebasic.loan;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    public long id;
    public int borrowerId;
    public int bookId;
    @Temporal(TemporalType.DATE)
    public Date borrowDate;
    @Temporal(TemporalType.DATE)
    public Date returnByDate;
    @Temporal(TemporalType.DATE)
    public Date returnDate;
    public boolean returned = false;
}
