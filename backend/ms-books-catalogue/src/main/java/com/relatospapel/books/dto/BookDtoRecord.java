package com.relatospapel.books.dto;

import java.math.BigDecimal;


public record BookDtoRecord(
        Integer idBook,
        String title,
        java.time.LocalDate datePublication,
        String isbn,
        BigDecimal price,
        int stock,
        String description
) {
}
