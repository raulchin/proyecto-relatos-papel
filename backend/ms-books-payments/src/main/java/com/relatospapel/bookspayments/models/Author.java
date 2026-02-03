package com.relatospapel.bookspayments.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    private Integer idAuthor;

    private String nameAuthor;

    private String lastNameAuthor;

    private String biografia;

    private Boolean statusAuthor = true;

}
