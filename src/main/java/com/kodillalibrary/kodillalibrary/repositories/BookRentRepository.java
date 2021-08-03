package com.kodillalibrary.kodillalibrary.repositories;

import com.kodillalibrary.kodillalibrary.domains.BookRent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookRentRepository extends CrudRepository<BookRent, Long> {
}
