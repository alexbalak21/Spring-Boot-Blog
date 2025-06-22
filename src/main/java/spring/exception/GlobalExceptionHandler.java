package spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Global exception handler that processes exceptions across the entire application.
 * Provides consistent error responses for different types of exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Unauthorized: Access denied");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.toString());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Unauthorized: Access denied");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.toString());
    }
}