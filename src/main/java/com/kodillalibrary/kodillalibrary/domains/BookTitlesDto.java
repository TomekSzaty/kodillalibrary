package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookTitlesDto {

    private Long bookTitleID;
    private String bookTitle;
    private String bookAuthor;
    private String bookYearPublication;
    private List<BookQuantity> bookQuantityList;
}
