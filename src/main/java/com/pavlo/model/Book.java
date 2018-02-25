package com.pavlo.model;

/**
 * Created by pavlo on 2/25/2018.
 */
public class Book {
    private long id;
    private String name;
    private String author;

    public Book() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
