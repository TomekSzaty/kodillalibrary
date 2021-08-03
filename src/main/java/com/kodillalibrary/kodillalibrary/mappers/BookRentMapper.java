package com.kodillalibrary.kodillalibrary.mappers;

import com.kodillalibrary.kodillalibrary.domains.BookRent;
import com.kodillalibrary.kodillalibrary.domains.BookRentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRentMapper {

    public BookRent mapToBookRent(final BookRentDto bookRentDto) {
        return new BookRent();
    }

    public BookRentDto mapToBookRentDto(final BookRent bookRent) {
        return new BookRentDto(
                bookRent.getBookRentID(),
                bookRent.getReaderID(),
                bookRent.getBookQuantityID(),
                bookRent.getBookRentWithdrawnDate(),
                bookRent.getBookRentReturnDate()
        );
    }
    public List<BookRent> mapToBookRentList (final List<BookRentDto> bookRentDtoList){
        return bookRentDtoList.stream()
                .map(this::mapToBookRent)
                .collect(Collectors.toList());
    }

    public List<BookRentDto> mapToBookRentListDto(final List<BookRent> bookRentList){
        return bookRentList.stream()
                .map(this::mapToBookRentDto)
                .collect(Collectors.toList());
    }
}
