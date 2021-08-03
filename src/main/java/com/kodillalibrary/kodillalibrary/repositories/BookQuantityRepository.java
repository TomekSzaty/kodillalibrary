package com.kodillalibrary.kodillalibrary.repositories;

import com.kodillalibrary.kodillalibrary.domains.BookQuantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookQuantityRepository extends CrudRepository<BookQuantity, Long> {

    @Override
    List<BookQuantity> findAll();
}
