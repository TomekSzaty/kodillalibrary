package com.kodillalibrary.kodillalibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,  reason = "Book Title Not Found")
public class BookTitleNotFoundException extends RuntimeException {
}
