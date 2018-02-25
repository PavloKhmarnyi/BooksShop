package com.pavlo.controller;

import com.pavlo.model.Book;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pavlo on 2/25/2018.
 */

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String greeting() {
        return "Hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Book getBook(@RequestBody Book book) {
        book.setId(2);
        return book;
    }
}
