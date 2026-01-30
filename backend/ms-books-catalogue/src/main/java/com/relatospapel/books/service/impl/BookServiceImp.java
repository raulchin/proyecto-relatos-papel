package com.relatospapel.books.service.impl;


import com.relatospapel.books.dto.response.BookResponseRecord;
import com.relatospapel.books.entity.Book;
import com.relatospapel.books.exception.BookNotFoundException;
import com.relatospapel.books.exception.InvalidDataException;
import com.relatospapel.books.mapper.Mapper;
import com.relatospapel.books.repository.BookRepository;
import com.relatospapel.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public BookResponseRecord addBook(Book book) {
        if(book == null){
            throw new InvalidDataException("Book data can not be empty");
        }
        Book savedBook = bookRepository.save(book);
        log.info("Se registro el libro correctamemnte su id: {}", savedBook.getIdBook());
        return mapper.bookToBookResponseRecord(savedBook);
    }

    @Override
    public List<BookResponseRecord> getAllBooks() {

        return bookRepository.findAll().stream().map(book -> mapper.bookToBookResponseRecord(book)).toList();
    }

    @Override
    public BookResponseRecord getBookById(int id) {

            return mapper.bookToBookResponseRecord(bookRepository.findById(id)
                    .orElseThrow(() -> new BookNotFoundException("Book not found")));
        }

    @Override
    public void deleteBookById(int id) {

        if (id <= 0)
            throw new RuntimeException("id can not be 0 or negative number");
        bookRepository.deleteById(id);
    }
}
