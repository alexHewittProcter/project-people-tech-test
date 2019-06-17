package com.projectpeople.springboot2restservicebasic.search;

import com.projectpeople.springboot2restservicebasic.book.*;
import java.util.List;

public interface SearchService {
    /**
     * Unimplemented search function, returns books that match the term
     * @param term
     * @return books that match the term parameter
     */
    public abstract List<Book> search(String term);
}
