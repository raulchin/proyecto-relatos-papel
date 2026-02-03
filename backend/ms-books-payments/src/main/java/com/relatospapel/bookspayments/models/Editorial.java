package com.relatospapel.bookspayments.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //NO uses todos los campos para equals() y hashCode().Solo usa los campos marcados con @EqualsAndHashCode.Include.
public class Editorial {

    private Integer idEditorial;

    private String nameEditorial;

    private String urlEditorial;

    private Boolean statusEditorial = true;
}
