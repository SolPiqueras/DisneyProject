package ar.solPiqueras.disney.web.exceptions;

public class ServiceUnavailable extends RuntimeException {
    public ServiceUnavailable(String message) {
        super(message);
    }
}
