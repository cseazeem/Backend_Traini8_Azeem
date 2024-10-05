package com.traini8.Backend_Traini8_Azeem.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Define a custom exception and map it to 400 Bad Request
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrainingCenterAlreadyExistsException extends RuntimeException {

    // Constructor that takes a message
    public TrainingCenterAlreadyExistsException(String message) {
        super(message);
    }
}

