package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "BOOK_TITLES")
public class BookTitles {

    public BookTitles(String bookTitle, String bookAuthor, String booYearPublication) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.booYearPublication = booYearPublication;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_TITLE_ID")
    private Long bookTitleID;

    @Column(name = "BOOK_TITLE")
    private String bookTitle;

    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;

    @Column(name = "BOOK_YEAR_PUBLICATION")
    private String booYearPublication;

    @OneToMany(
            targetEntity = BookQuantity.class,
            mappedBy = "bookTitleID",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private final List<BookQuantity> bookQuantityList = new ArrayList<>();
}
