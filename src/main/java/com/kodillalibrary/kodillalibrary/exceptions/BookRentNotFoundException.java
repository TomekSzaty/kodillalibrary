package com.kodillalibrary.kodillalibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book Rent Not Found")
public class BookRentNotFoundException extends RuntimeException {
}
