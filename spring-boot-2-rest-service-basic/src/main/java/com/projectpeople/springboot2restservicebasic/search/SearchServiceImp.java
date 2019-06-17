package com.projectpeople.springboot2restservicebasic.search;

import com.projectpeople.springboot2restservicebasic.book.Book;
import com.projectpeople.springboot2restservicebasic.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImp implements SearchService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Implemented search method
     * This searches through all stored books, returning any books that have the search term in the title
     * or in the otherDetails
     * @param term
     * @return a list of books that match the search term
     */
    @Override
    public List<Book> search(String term) {
        term = term.toLowerCase();
        List<Book> foundBooks = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if(book.title.toLowerCase().contains(term) || book.otherDetails.toLowerCase().contains(term)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
