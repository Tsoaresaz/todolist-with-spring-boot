package br.com.todolist.desafiobackendjr.desafio_todolist.v1.controller;

import br.com.todolist.desafiobackendjr.desafio_todolist.v1.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }
}


//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List<String> messages = ex.getBindingResult()
//                .getAllErrors()
//                .stream()
//                .map(error -> {
//                    if (error instanceof FieldError fieldError) {
//                        return fieldError.getField() + ": " + error.getDefaultMessage();
//                    }
//                    return error.getDefaultMessage();
//                })
//                .collect(Collectors.toList());
//
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                "Erro de validação",
//                messages
//        );
//
//        return ResponseEntity.badRequest().body(errorResponse);
//    }
//}
