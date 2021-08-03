package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRentDto {
    private Long bookRentID;
    private Reader readerID;
    private BookQuantity bookQuantityID;
    private LocalDate bookRentWithdrawnDate;
    private LocalDate bookRentReturnDate;
}
