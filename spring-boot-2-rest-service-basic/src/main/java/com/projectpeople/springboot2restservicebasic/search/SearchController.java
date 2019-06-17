package com.projectpeople.springboot2restservicebasic.search;

import com.projectpeople.springboot2restservicebasic.book.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The SearchController is used to for all the search functionality
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * Url implementation of the search functionality
     * Using the url /search/{term} where the term is what is being searched
     * This uses the searchService for the business logic
     * @param term
     * @return a list of books that match the term
     */
    @GetMapping("/search/{term}")
    public List<Book> searchForBook(@PathVariable String term) {
        List<Book> foundBooks = searchService.search(term);
        return foundBooks;
    }
}
