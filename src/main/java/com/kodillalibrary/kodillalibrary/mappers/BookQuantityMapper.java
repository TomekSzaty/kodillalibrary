package com.kodillalibrary.kodillalibrary.mappers;

import com.kodillalibrary.kodillalibrary.domains.BookQuantity;
import com.kodillalibrary.kodillalibrary.domains.BookQuantityDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookQuantityMapper {

    public BookQuantity mapToBookQuantity(final BookQuantityDto bookQuantityDto) {
        return new BookQuantity();
    }

    public BookQuantityDto mapToBookQuantityDto(final BookQuantity bookQuantity) {
        return new BookQuantityDto(
                bookQuantity.getBookQtyID(),
                bookQuantity.getBookTitleID(),
                bookQuantity.getBookQtyStatus()
        );
    }
    public List<BookQuantity> mapToBookQuantityList(final List<BookQuantityDto> bookQuantityDtoList){
        return bookQuantityDtoList.stream()
                .map(this::mapToBookQuantity)
                .collect(Collectors.toList());
    }

    public List<BookQuantityDto> mapToBookQuantityListDto(final List<BookQuantity> bookQuantityList){
        return bookQuantityList.stream()
                .map(this::mapToBookQuantityDto)
                .collect(Collectors.toList());
    }
}
