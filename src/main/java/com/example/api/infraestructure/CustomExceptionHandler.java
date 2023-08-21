package com.example.api.infraestructure;
import com.example.api.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends Throwable {

    private String message;
    public CustomExceptionHandler() {
    }

    public CustomExceptionHandler(String message) {
        this.message = message;
    }

    public CustomExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomExceptionHandler(Throwable cause) {
        super(cause);
    }

    public CustomExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> handleGenericException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorMessageDTO("422","Bad Request"));
    }




}
