package com.kodillalibrary.kodillalibrary.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReaderDto {
    private Long readerID;
    private String readerName;
    private String readerLastName;
    private LocalDate readerAccountDateCreated;
}
