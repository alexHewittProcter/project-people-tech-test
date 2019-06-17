package com.projectpeople.springboot2restservicebasic.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            book.id = id;
            bookRepository.save(book);
            return book;
        } else {
            return null;
        }
    }

}
