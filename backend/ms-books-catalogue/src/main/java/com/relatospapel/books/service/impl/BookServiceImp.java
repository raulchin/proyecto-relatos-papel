package com.relatospapel.books.service.impl;

import com.relatospapel.books.dto.BookDtoRecord;
import com.relatospapel.books.entity.Book;
import com.relatospapel.books.mapper.Mapper;
import com.relatospapel.books.repository.BookRepository;
import com.relatospapel.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public BookDtoRecord addBook(Book book) {
        if(book == null){
            //throw new InvalidDataException("Book data can not be empty");
        }
        Book savedBook = bookRepository.save(book);
        return mapper.bookToBookDtoRecord(savedBook);
    }
}
