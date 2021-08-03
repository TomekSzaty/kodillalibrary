package com.kodillalibrary.kodillalibrary.services;

import com.kodillalibrary.kodillalibrary.domains.BookQuantity;
import com.kodillalibrary.kodillalibrary.exceptions.BookQuantityNotFoundException;
import com.kodillalibrary.kodillalibrary.repositories.BookQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQuantityService {

    @Autowired
    private BookQuantityRepository bookQuantityRepository;

    public BookQuantity createQuantity(final BookQuantity bookQuantity) {
        return bookQuantityRepository.save(bookQuantity);
    }

    public BookQuantity getQuantityById(final Long bookQuantityId) throws BookQuantityNotFoundException {
        return bookQuantityRepository.findById(bookQuantityId).orElseThrow(BookQuantityNotFoundException::new);
    }

    public List<BookQuantity> getQuantityAll() {
        return bookQuantityRepository.findAll();
    }
    public BookQuantity updateQuantityStatus(final BookQuantity bookQuantity) throws BookQuantityNotFoundException {
        BookQuantity bookQuantityUpdate = bookQuantityRepository.findById(bookQuantity.getBookQtyID()).orElseThrow(BookQuantityNotFoundException::new);
        bookQuantityUpdate.setBookQtyStatus(bookQuantity.getBookQtyStatus());

        return bookQuantityRepository.save(bookQuantityUpdate);
    }

    public BookQuantity updateQuantityStatusLost(final Long bookQuantityID) throws BookQuantityNotFoundException {
        BookQuantity bookQuantityUpdate = bookQuantityRepository.findById(bookQuantityID).orElseThrow(BookQuantityNotFoundException::new);
        bookQuantityUpdate.setBookQtyStatus("Lost");

        return bookQuantityRepository.save(bookQuantityUpdate);
    }

    public void deleteQuantityByID(final Long bookQuantityID) throws BookQuantityNotFoundException {
        BookQuantity deleteQuantity = bookQuantityRepository.findById(bookQuantityID).orElseThrow(BookQuantityNotFoundException::new);

        bookQuantityRepository.delete(deleteQuantity);
    }
}
