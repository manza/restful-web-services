package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserInvalidException extends RuntimeException {

    public UserInvalidException(String message) {
        super(message);
    }

}
