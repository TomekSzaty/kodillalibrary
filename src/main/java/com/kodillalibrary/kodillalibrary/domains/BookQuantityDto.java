package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookQuantityDto {
    private Long bookQtyID;
    private BookTitles bookTitleID;
    private String bookQtyStatus;
}
