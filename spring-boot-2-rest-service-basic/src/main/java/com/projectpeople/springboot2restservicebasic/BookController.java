package com.projectpeople.springboot2restservicebasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> index() {
        System.out.println("Called");
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }


}
