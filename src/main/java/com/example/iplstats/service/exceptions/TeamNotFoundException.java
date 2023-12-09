package com.example.iplstats.service.exceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String message){
        super(message);
    }
}
