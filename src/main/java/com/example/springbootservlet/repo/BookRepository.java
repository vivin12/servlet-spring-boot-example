package com.example.springbootservlet.repo;

import com.example.springbootservlet.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer> {
    @Override
    List<Book> findAll();
}
