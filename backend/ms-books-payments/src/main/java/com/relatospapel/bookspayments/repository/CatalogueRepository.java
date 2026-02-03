package com.relatospapel.bookspayments.repository;

import com.relatospapel.bookspayments.beans.LoadBalancerConfiguration;
import com.relatospapel.bookspayments.models.Book;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

@FeignClient(name = "ms-books-catalogue")
@LoadBalancerClient(name = "ms-books-catalogue", configuration = LoadBalancerConfiguration.class)
public interface CatalogueRepository {

    @GetMapping(path = "/api/v1/books/{id}")
    Optional<Book> findById(@PathVariable int id);
}
