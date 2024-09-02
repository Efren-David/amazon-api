package com.amazonapi.amazonapi.Exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(long userId) {
        super("User " + userId + " not found");
    }

    public UserNotFoundException() {
        super("User not found");
    }
}
