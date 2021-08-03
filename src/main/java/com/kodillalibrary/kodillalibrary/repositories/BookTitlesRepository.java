package com.kodillalibrary.kodillalibrary.repositories;

import com.kodillalibrary.kodillalibrary.domains.BookTitles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookTitlesRepository extends CrudRepository<BookTitles, Long> {
    @Override
    List<BookTitles> findAll();
}
