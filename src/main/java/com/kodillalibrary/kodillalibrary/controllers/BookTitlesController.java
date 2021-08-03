package com.kodillalibrary.kodillalibrary.controllers;


import com.kodillalibrary.kodillalibrary.domains.BookTitles;
import com.kodillalibrary.kodillalibrary.domains.BookTitlesDto;
import com.kodillalibrary.kodillalibrary.exceptions.BookQuantityNotFoundException;
import com.kodillalibrary.kodillalibrary.exceptions.BookTitleNotFoundException;
import com.kodillalibrary.kodillalibrary.mappers.BookTitlesMapper;
import com.kodillalibrary.kodillalibrary.services.BookTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/titles")
public class BookTitlesController {

    @Autowired
    private BookTitlesService bookTitlesService;

    @Autowired
    private BookTitlesMapper bookTitlesMapper;

    @PostMapping(value = "createBookTitle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBookTitle(@RequestBody BookTitlesDto bookTitlesDto) {
        bookTitlesService.createBookTitle(bookTitlesMapper.mapToBookTitles(bookTitlesDto));
    }

    @GetMapping(value = "/getAllBookTitles")
    public List<BookTitlesDto> getAllBookTitles() throws BookTitleNotFoundException {
        return bookTitlesMapper.mapToBookTitlesDto(bookTitlesService.getBookInfoAll());
    }

    @PutMapping(value = "/updateBook")
    public BookTitlesDto updateBook(@RequestBody BookTitlesDto bookTitlesDto) throws BookQuantityNotFoundException {
        BookTitles bookTitlesUpdate = bookTitlesService.updateBookInfo(bookTitlesMapper.mapToBookTitles(bookTitlesDto));
        return bookTitlesMapper.mapToBBookTitlesDto(bookTitlesUpdate);
    }

}
