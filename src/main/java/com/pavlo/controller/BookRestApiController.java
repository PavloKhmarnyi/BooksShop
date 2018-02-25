package com.pavlo.controller;

import com.pavlo.model.Book;
import com.pavlo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by pavlo on 2/25/2018.
 */

@RestController
@RequestMapping("/api")
public class BookRestApiController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> insertBook(@RequestBody Book book, UriComponentsBuilder componentsBuilder) {
        long id = bookService.saveBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.set("id", String.valueOf(id));
        return new ResponseEntity<Long>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookByName(@PathVariable("name") String name) {
        Book book = bookService.getBookByName(name);
        if (book == null) {
            return new ResponseEntity("Book with name: " + name + " not found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBookByName(@PathVariable("name") String name) {
        Book book = bookService.getBookByName(name);
        if (book == null) {
            return new ResponseEntity("Book with name " + name + " not found!", HttpStatus.NOT_FOUND);
        }

        bookService.deleteBookByName(name);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
