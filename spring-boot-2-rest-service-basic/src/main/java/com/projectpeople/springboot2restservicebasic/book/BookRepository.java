package com.projectpeople.springboot2restservicebasic.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * An extension of the JPA repository for use of the Books table
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
