package br.com.todolist.desafiobackendjr.desafio_todolist.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api/todolist")
public class TodoList {

    @GetMapping
    public String helloWorld() {
        return ResponseEntity.status(200).body("Hello World").toString();
    }
}
