package com.example.iplstats.advisor;

import com.example.iplstats.dto.ErrorResponseDto;
import com.example.iplstats.service.exceptions.TeamNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IplStatsExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(TeamNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
