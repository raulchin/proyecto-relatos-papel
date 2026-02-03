package com.relatospapel.bookspayments.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    private Integer idBook;

    private String title;

    private LocalDate datePublication;

    private String isbn;

    private BigDecimal price;

    private int stock = 0;

    private String description;

    private int assessment;

    private Boolean visibility = true;

    private Editorial editorial;

    private Author author;

}
