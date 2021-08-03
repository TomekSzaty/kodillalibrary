package com.kodillalibrary.kodillalibrary.domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOK_RENTS")
public class BookRent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_RENT_ID", unique = true)
    private Long bookRentID;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "READER_ID")
    private Reader readerID;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_QUANTITY_ID")
    private BookQuantity bookQuantityID;


    @Column(name = "BOOK_RENT_WITHDRAWN_DATE")
    private LocalDate bookRentWithdrawnDate;


    @Column(name = "BOOK_RENT_RETURN_DATE")
    private LocalDate bookRentReturnDate;
}
