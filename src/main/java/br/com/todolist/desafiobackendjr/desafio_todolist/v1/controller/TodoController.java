package br.com.todolist.desafiobackendjr.desafio_todolist.v1.controller;

import br.com.todolist.desafiobackendjr.desafio_todolist.v1.dto.RegisterTodoListDTO;
import br.com.todolist.desafiobackendjr.desafio_todolist.v1.entity.Todo;
import br.com.todolist.desafiobackendjr.desafio_todolist.v1.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TodoList Controller", description = "Endpoints para o gerenciamento da TodoList")
@RestController
@RequestMapping(path = "/v1/api/todolist")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/hello")
    public String helloWorld() {
        return ResponseEntity.status(200).body("Hello World").toString();
    }

    @GetMapping
    public ResponseEntity<List<RegisterTodoListDTO>> findAllTodoList() {
        List<RegisterTodoListDTO> todos = service.findAllTodoList();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterTodoListDTO> findTodoListById(@Valid @PathVariable Long id) {
        RegisterTodoListDTO result = service.findTodoListById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<RegisterTodoListDTO> saveTodoList(@Valid @RequestBody RegisterTodoListDTO todo) {
        RegisterTodoListDTO newTodo = service.saveTodoList(Todo.fromDTO(todo));
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterTodoListDTO> updateTodoList(@PathVariable Long id, @RequestBody RegisterTodoListDTO dto) {
        RegisterTodoListDTO updateResponse = service.updateTodoList(id, Todo.fromDTO(dto));
        return ResponseEntity.ok(updateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoList(@PathVariable Long id) {
        service.deleteTodoList(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
