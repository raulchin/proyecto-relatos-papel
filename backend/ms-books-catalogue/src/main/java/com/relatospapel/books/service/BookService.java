package com.relatospapel.books.service;

import com.relatospapel.books.dto.response.BookResponseRecord;
import com.relatospapel.books.entity.Book;

import java.util.List;

public interface BookService {

    BookResponseRecord addBook(Book book);

    List<BookResponseRecord> getAllBooks();

    BookResponseRecord getBookById(int id);

    void deleteBookById(int id);
}
