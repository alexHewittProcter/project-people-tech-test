package com.projectpeople.springboot2restservicebasic;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    private long id;
    private int borrowerId;
    private int bookId;
    @Temporal(TemporalType.DATE)
    private Date borrowDate;
    @Temporal(TemporalType.DATE)
    private Date returnByDate;
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    private boolean returned = false;
}
