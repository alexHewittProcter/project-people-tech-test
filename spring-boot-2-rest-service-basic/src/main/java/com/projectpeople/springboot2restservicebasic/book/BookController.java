package com.projectpeople.springboot2restservicebasic.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired private BookRepository bookRepository;

    /**
     * Used to show all books stored
     * Using the url /books
     * @return list of books
     */
    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    /**
     * Gets a specific book based on the id provided
     * Accessed using /books/id
     * @param id
     * @return a book object
     */
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    /**
     * Deletes a specific book from the database using a specific id
     * Uses a DELETE request at the url /books/id
     * @param id
     */
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Adds a book to the database store using a POST request
     * At the /books url
     * @param book
     * @return the created book object
     */
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    /**
     * Updates a book based on a specific id
     * Uses a PUT request with the url /books/id
     * @param book
     * @param id
     * @return the updated book
     */
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
