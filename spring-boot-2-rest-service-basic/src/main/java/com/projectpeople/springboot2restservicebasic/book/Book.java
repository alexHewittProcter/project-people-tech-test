package com.projectpeople.springboot2restservicebasic.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    public long id;
    public String title;
    public String isbn;
    public String otherDetails;
}
