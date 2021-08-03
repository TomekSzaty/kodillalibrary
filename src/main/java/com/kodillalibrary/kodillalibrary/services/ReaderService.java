package com.kodillalibrary.kodillalibrary.services;

import com.kodillalibrary.kodillalibrary.domains.Reader;
import com.kodillalibrary.kodillalibrary.exceptions.ReaderNotFoundException;
import com.kodillalibrary.kodillalibrary.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public Reader createReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader getReaderByID(final Long readerId) throws ReaderNotFoundException {
        return readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public List<Reader> getReaderAll() {
        return readerRepository.findAll();
    }

    public Reader updateReader(final Reader reader) throws ReaderNotFoundException {
        Reader updatedReader = readerRepository.findById(reader.getReaderId()).orElseThrow(ReaderNotFoundException::new);
        updatedReader.setReaderName(reader.getReaderName());
        updatedReader.setReaderLastName(reader.getReaderLastName());
        updatedReader.setReaderAccountDateCreated(reader.getReaderAccountDateCreated());

        return readerRepository.save(updatedReader);
    }

    public void deleteReaderByID(final Long readerId) throws ReaderNotFoundException {
        Reader deleteReader = readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);

        readerRepository.delete(deleteReader);
    }
}
