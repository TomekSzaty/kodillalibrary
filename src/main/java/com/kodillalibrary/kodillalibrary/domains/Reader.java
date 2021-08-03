package com.kodillalibrary.kodillalibrary.domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "READERS")
public class Reader {

    public Reader(String readerName, String readerLastName, LocalDate readerAccountDateCreated) {
        this.readerName = readerName;
        this.readerLastName = readerLastName;
        this.readerAccountDateCreated = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "READER_ID", unique = true)
    private Long readerId;


    @Column(name = "READER_NAME")
    private String readerName;

    @Column(name = "READER_LASTNAME")
    private String readerLastName;

    @Column(name = "READER_ACCOUNT_DATE_CREATED")
    private LocalDate readerAccountDateCreated;
}
