package com.relatospapel.bookspayments.client;

import com.relatospapel.bookspayments.dto.BookResponse;
import com.relatospapel.bookspayments.dto.StockUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-books-catalogue", path = "/api")
public interface BooksCatalogueClient {

    @GetMapping(path = "/v1/books/{id}")
    BookResponse findBookById(@PathVariable int id);

    @PatchMapping("/v1/books/{id}")
    BookResponse updateBookQuantity(@PathVariable int id, StockUpdateRequest request);

}
