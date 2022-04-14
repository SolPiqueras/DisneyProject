package ar.solPiqueras.disney.web.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
    
}