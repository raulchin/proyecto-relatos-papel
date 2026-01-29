package com.relatospapel.books.controller;

import com.relatospapel.books.dto.BookDtoRecord;
import com.relatospapel.books.dto.request.BookCreateRequest;
import com.relatospapel.books.entity.Book;
import com.relatospapel.books.mapper.Mapper;
import com.relatospapel.books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
@Tag(name = "Book Controller",
        description = "All CRUD operations for Book service and many APIs to be used by other micro-services")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    private Mapper mapper;

    @Operation(summary = "Add new book", description = "Add new book")
    @ApiResponses(value = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<BookDtoRecord> addBook( @RequestBody BookCreateRequest request){

        log.info("INGRESO...{}",request);
        Book book = mapper.bookCreateRequestToBook(request);
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);

        //return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }
}
