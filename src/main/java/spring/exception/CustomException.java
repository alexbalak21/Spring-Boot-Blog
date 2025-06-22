package spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Default status code for this exception
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}