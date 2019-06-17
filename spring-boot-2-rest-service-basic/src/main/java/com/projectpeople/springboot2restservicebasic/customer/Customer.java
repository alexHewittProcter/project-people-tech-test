package com.projectpeople.springboot2restservicebasic.customer;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    public long id;
    public String name;
    public String address;
    public String phoneNumber;
    public String email;
}
