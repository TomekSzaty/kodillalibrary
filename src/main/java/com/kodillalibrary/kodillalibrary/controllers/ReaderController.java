package com.kodillalibrary.kodillalibrary.controllers;

import com.kodillalibrary.kodillalibrary.domains.ReaderDto;
import com.kodillalibrary.kodillalibrary.exceptions.ReaderNotFoundException;
import com.kodillalibrary.kodillalibrary.mappers.ReaderMapper;
import com.kodillalibrary.kodillalibrary.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private ReaderMapper readerMapper;

    @PostMapping(value = "/createReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto){
        readerService.createReader(readerMapper.mapToReader(readerDto));
    }

    @GetMapping(value = "/getAllReaders")
    public List<ReaderDto> getAllReaders() throws ReaderNotFoundException {
        return readerMapper.mapToReaderDtoList(readerService.getReaderAll());
    }
}
