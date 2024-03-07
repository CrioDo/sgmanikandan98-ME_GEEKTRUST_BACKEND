package com.geektrust.backend.Exception;

public class NosuchCommandException extends RuntimeException {

    public NosuchCommandException() {
        super();
    }

    public NosuchCommandException(String message) {
        super(message);
    }
    
    
}
