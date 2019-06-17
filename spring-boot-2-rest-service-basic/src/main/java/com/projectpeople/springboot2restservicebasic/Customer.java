package com.projectpeople.springboot2restservicebasic;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}
