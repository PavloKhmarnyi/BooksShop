package com.pavlo.mapper;

import com.pavlo.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by pavlo on 2/25/2018.
 */

@Mapper
@Component
public interface BookMapper {

    @Insert("insert into books(Name, Author) values(#{name}, #{author})")
    long saveBook(Book book);

    @Select("select * from books where Name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "author", column = "author")
    })
    Book getBookByName(String name);

    @Delete("delete from books where Name = #{name}")
    void deleteBook(String name);
}
