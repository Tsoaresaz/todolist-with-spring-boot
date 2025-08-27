package br.com.todolist.desafiobackendjr.desafio_todolist.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data // Gera getters, settter, equals, hashCOde e toString
@AllArgsConstructor // Gera constructor com todos os arqumentos
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> messages;

    public ErrorResponse(int status, String error, List<String> messages) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.messages = messages;
    }
}
