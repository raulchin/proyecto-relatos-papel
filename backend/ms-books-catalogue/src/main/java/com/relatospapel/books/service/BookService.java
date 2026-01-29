package com.relatospapel.books.service;

import com.relatospapel.books.dto.BookDtoRecord;
import com.relatospapel.books.entity.Book;

public interface BookService {

    BookDtoRecord addBook(Book book);
}
