package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOOK_QUANTITY")
public class BookQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_QUANTITY_ID", unique = true)
    private Long bookQtyID;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_TITLE_ID")
    private BookTitles bookTitleID;

    @Column(name = "BOOK_QUANTITY_STATUS")
    private String bookQtyStatus;


}
