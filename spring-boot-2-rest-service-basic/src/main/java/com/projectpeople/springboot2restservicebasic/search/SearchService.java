package com.projectpeople.springboot2restservicebasic.search;

import com.projectpeople.springboot2restservicebasic.book.*;
import java.util.List;

public interface SearchService {
    public abstract List<Book> search(String term);
}
