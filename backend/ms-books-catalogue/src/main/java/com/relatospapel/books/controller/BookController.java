package com.relatospapel.books.controller;

import com.relatospapel.books.common.LogService;
import com.relatospapel.books.dto.request.BookCreateRequest;
import com.relatospapel.books.dto.response.BookResponseRecord;
import com.relatospapel.books.entity.Book;
import com.relatospapel.books.mapper.Mapper;
import com.relatospapel.books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/v1/books")
@Tag(name = "Book Controller",
        description = "All CRUD operations for Book service and many APIs to be used by other micro-services")
@Slf4j
public class BookController {

    private static final String KEY = "uuid";

    @Autowired
    BookService bookService;

    @Autowired
    private Mapper mapper;

    @Autowired
    LogService logService;

    @Operation(summary = "Add new book", description = "Add new book")
    @ApiResponses(value = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<BookResponseRecord> addBook(@RequestBody BookCreateRequest request){

        log.info("Inicia proceso para agregar un libro...");
        logService.logAsJson(request);
        Book book = mapper.bookCreateRequestToBook(request);
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);

    }

    @Operation(summary = "Get a book", description = "Get a book")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseRecord> getBook(@Parameter(description = "ID of book to be retrieved",
            required = true) @PathVariable int id) {

        log.info("Obtener un libro segun si id: {}",id);
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);

    }

    @Operation(summary = "Get all book", description = "Get all books")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping
    public ResponseEntity<List<BookResponseRecord>> getAllBook() {

        log.info("Obtener todos los libros regitrados...");
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);

    }

    @Operation(summary = "Delete a book", description = "Delete a book")
    @ApiResponses(value = {@ApiResponse(responseCode = "204")})
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable int id) {
        log.info("Proceso para eliminar un libro con el id: {}",id);
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
