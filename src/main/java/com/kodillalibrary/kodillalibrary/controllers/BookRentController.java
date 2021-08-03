package com.kodillalibrary.kodillalibrary.controllers;

import com.kodillalibrary.kodillalibrary.domains.BookRent;
import com.kodillalibrary.kodillalibrary.domains.BookRentDto;
import com.kodillalibrary.kodillalibrary.exceptions.BookRentNotFoundException;
import com.kodillalibrary.kodillalibrary.mappers.BookRentMapper;
import com.kodillalibrary.kodillalibrary.services.BookRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/rents")
public class BookRentController {

    @Autowired
    private BookRentService bookRentService;

    @Autowired
    private BookRentMapper bookRentMapper;

    @PostMapping(value = "/createBookRent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBookRent(@RequestBody BookRentDto bookRentDto) {
        bookRentService.createBookRent(bookRentMapper.mapToBookRent(bookRentDto));
    }
    @PutMapping(value = "/bookRentWithdrawn")
    public BookRentDto bookRentWithdrawn(@RequestParam BookRentDto bookRentDto) throws BookRentNotFoundException {
        BookRent bookRentWithdrawn = bookRentService.rentWithdrawDate(bookRentMapper.mapToBookRent(bookRentDto));
        bookRentWithdrawn.setBookRentWithdrawnDate(LocalDate.now());

        return bookRentMapper.mapToBookRentDto(bookRentWithdrawn);
    }

    @PutMapping(value = "/bookRentReturn")
    public BookRentDto bookRentReturn(@RequestParam BookRentDto bookRentDto) throws BookRentNotFoundException {
        BookRent bookRentReturn = bookRentService.rentWithdrawDate(bookRentMapper.mapToBookRent(bookRentDto));
        bookRentReturn.setBookRentReturnDate(LocalDate.now());

        return bookRentMapper.mapToBookRentDto(bookRentReturn);
    }
}
