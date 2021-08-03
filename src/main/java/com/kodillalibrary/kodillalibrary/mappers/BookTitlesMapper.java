package com.kodillalibrary.kodillalibrary.mappers;

import com.kodillalibrary.kodillalibrary.domains.BookTitles;
import com.kodillalibrary.kodillalibrary.domains.BookTitlesDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTitlesMapper {

    public BookTitles mapToBookTitles(final BookTitlesDto bookTitlesDto) {
        return new BookTitles(
                bookTitlesDto.getBookTitle(),
                bookTitlesDto.getBookAuthor(),
                bookTitlesDto.getBookYearPublication()
        );
    }

    public BookTitlesDto mapToBBookTitlesDto(final BookTitles bookTitles) {
        return new BookTitlesDto(
                bookTitles.getBookTitleID(),
                bookTitles.getBookTitle(),
                bookTitles.getBookAuthor(),
                bookTitles.getBooYearPublication(),
                bookTitles.getBookQuantityList()
        );
    }

    public List<BookTitles> mapToBookTitles(final List<BookTitlesDto> bookTitlesDtoList) {
        return bookTitlesDtoList.stream()
                .map(this::mapToBookTitles)
                .collect(Collectors.toList());
    }

    public List<BookTitlesDto> mapToBookTitlesDto(final List<BookTitles> bookTitlesList) {
        return bookTitlesList.stream()
                .map(this::mapToBBookTitlesDto)
                .collect(Collectors.toList());
    }
}
