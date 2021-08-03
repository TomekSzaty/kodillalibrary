package com.kodillalibrary.kodillalibrary.services;

import com.kodillalibrary.kodillalibrary.domains.BookTitles;
import com.kodillalibrary.kodillalibrary.exceptions.BookTitleNotFoundException;
import com.kodillalibrary.kodillalibrary.repositories.BookTitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTitlesService {

    @Autowired
    private BookTitlesRepository bookTitlesRepository;

    public BookTitles createBookTitle(final BookTitles bookTitles) {
        return bookTitlesRepository.save(bookTitles);
    }

    public BookTitles getBookInfoById(final Long bookInfoId) throws BookTitleNotFoundException {
        return bookTitlesRepository.findById(bookInfoId).orElseThrow(BookTitleNotFoundException::new);
    }

    public List<BookTitles> getBookInfoAll() {
        return bookTitlesRepository.findAll();
    }

    public BookTitles updateBookInfo(final BookTitles bookTitles) throws BookTitleNotFoundException {
        BookTitles bookTitlesUpdated = bookTitlesRepository.findById(bookTitles.getBookTitleID()).orElseThrow(BookTitleNotFoundException::new);
        bookTitlesUpdated.setBookTitle(bookTitles.getBookTitle());
        bookTitlesUpdated.setBookAuthor(bookTitles.getBookAuthor());
        bookTitlesUpdated.setBooYearPublication(bookTitles.getBooYearPublication());

        return bookTitlesRepository.save(bookTitlesUpdated);
    }

    public void deleteBookInfo(final Long bookInfoId) throws BookTitleNotFoundException {
        BookTitles bookTitles1 = bookTitlesRepository.findById(bookInfoId).orElseThrow(BookTitleNotFoundException::new);

        bookTitlesRepository.delete(bookTitles1);
    }
}
