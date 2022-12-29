package com.example.Ewallet;

public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String s) {
        super(s);
    }
}
