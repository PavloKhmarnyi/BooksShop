package com.pavlo.service;

import com.pavlo.mapper.BookMapper;
import com.pavlo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pavlo on 2/25/2018.
 */
@Service("BookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public long saveBook(Book book) {
        return bookMapper.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBookByName(String name) {
        return bookMapper.getBookByName(name);
    }

    @Override
    @Transactional
    public void deleteBookByName(String name) {
        bookMapper.deleteBook(name);
    }
}
