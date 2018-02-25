package com.pavlo.service;

import com.pavlo.model.Book;

/**
 * Created by pavlo on 2/25/2018.
 */
public interface BookService {
    long saveBook(Book book);
    Book getBookByName(String name);
    void deleteBookByName(String name);
}
