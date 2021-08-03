package com.kodillalibrary.kodillalibrary.controllers;

import com.kodillalibrary.kodillalibrary.domains.BookQuantity;
import com.kodillalibrary.kodillalibrary.domains.BookQuantityDto;
import com.kodillalibrary.kodillalibrary.exceptions.BookQuantityNotFoundException;
import com.kodillalibrary.kodillalibrary.mappers.BookQuantityMapper;
import com.kodillalibrary.kodillalibrary.services.BookQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/quantity")
public class BookQuantityController {

    @Autowired
    private BookQuantityService bookQuantityService;

    @Autowired
    private BookQuantityMapper bookQuantityMapper;

    @PostMapping(value = "/createBookQuantity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBookQuantity(@RequestBody BookQuantityDto bookQuantityDto) {
        bookQuantityService.createQuantity(bookQuantityMapper.mapToBookQuantity(bookQuantityDto));
    }
    @PutMapping(value = "/changeStatus")
    public BookQuantityDto changeBookQuantityStatus(@RequestBody BookQuantityDto bookQuantityDto) throws BookQuantityNotFoundException {
        BookQuantity bookQuantityChangedStatus = bookQuantityService.updateQuantityStatus(bookQuantityMapper.mapToBookQuantity(bookQuantityDto));
        return bookQuantityMapper.mapToBookQuantityDto(bookQuantityChangedStatus);
    }

    @PutMapping(value = "/changeStatusToLost")
    public void changeBookQuantityStatusToLost(@RequestParam Long bookQuantityID) throws BookQuantityNotFoundException{
        //bookQuantityMapper.mapToBookQuantityDto(bookQuantityService.updateQuantityStatusLost(bookQuantityID));
        bookQuantityService.updateQuantityStatusLost(bookQuantityID);
    }

    @GetMapping(value = "/checkQuantity")
    public List<BookQuantityDto> getAllQuantity() throws BookQuantityNotFoundException{
        return bookQuantityMapper.mapToBookQuantityListDto(bookQuantityService.getQuantityAll());
    }
}
