package com.relatospapel.books.mapper;

import com.relatospapel.books.dto.BookDtoRecord;
import com.relatospapel.books.dto.request.BookCreateRequest;
import com.relatospapel.books.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public BookDtoRecord  bookToBookDtoRecord(Book book){

        if(book == null){
            throw new NullPointerException("The Book should not be null");
        }
        return new BookDtoRecord(book.getIdBook(),book.getTitle(),
                book.getDatePublication(),book.getIsbn(),book.getPrice(),book.getStock(),book.getDescription());
    }

    public Book bookCreateRequestToBook(BookCreateRequest createRequest){
        if(createRequest == null){
            throw new NullPointerException("The Book DTO should not be null");
        }
        Book book = new Book();
        book.setTitle(createRequest.title());
        book.setDatePublication(createRequest.datePublication());
        book.setIsbn(createRequest.isbn());
        book.setPrice(createRequest.price());
        book.setStock(createRequest.stock());
        book.setDescription(createRequest.description());
        book.setAssessment(createRequest.assessment());
        book.setVisibility(createRequest.visibility());

        return book;
    }
}
