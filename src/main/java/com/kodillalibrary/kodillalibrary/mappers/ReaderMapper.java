package com.kodillalibrary.kodillalibrary.mappers;

import com.kodillalibrary.kodillalibrary.domains.Reader;
import com.kodillalibrary.kodillalibrary.domains.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader (final ReaderDto readerDto){
        return new Reader(
                readerDto.getReaderName(),
                readerDto.getReaderLastName(),
                readerDto.getReaderAccountDateCreated());
    }

    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getReaderId(),
                reader.getReaderName(),
                reader.getReaderLastName(),
                reader.getReaderAccountDateCreated());
    }

    public List<ReaderDto> mapToReaderDtoList (final List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }

    public List<Reader> mapToReaderList (final List<ReaderDto> readerDtoList){
        return readerDtoList.stream()
                .map(this::mapToReader)
                .collect(Collectors.toList());
    }
}
