package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date date;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
