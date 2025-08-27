package br.com.todolist.desafiobackendjr.desafio_todolist.v1.service;

import br.com.todolist.desafiobackendjr.desafio_todolist.v1.dto.RegisterTodoListDTO;
import br.com.todolist.desafiobackendjr.desafio_todolist.v1.entity.Todo;
import br.com.todolist.desafiobackendjr.desafio_todolist.v1.exception.TodoNotFoundException;
import br.com.todolist.desafiobackendjr.desafio_todolist.v1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<RegisterTodoListDTO> findAllTodoList() {
        return repository.findAll().stream()
                .map(todo -> new RegisterTodoListDTO(todo.getId(), todo.getNome(), todo.getDescricao(), todo.getRealizado(), todo.getPrioridade())).toList();
    }

    public RegisterTodoListDTO findTodoListById(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        return new RegisterTodoListDTO(todo.getId(), todo.getNome(), todo.getDescricao(), todo.getRealizado(), todo.getPrioridade());
    }

    public RegisterTodoListDTO saveTodoList(Todo todo) {
        Todo newTodo = repository.save(todo);
        return new RegisterTodoListDTO(newTodo.getId(), newTodo.getNome(), newTodo.getDescricao(),  newTodo.getRealizado(), newTodo.getPrioridade());
    }

    public RegisterTodoListDTO updateTodoList(Long id, Todo todo) {
        Todo existTodoList = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        if (todo.getNome() != null) existTodoList.setNome(todo.getNome());
        if (todo.getDescricao() != null) existTodoList.setDescricao(todo.getDescricao());
        if (todo.getRealizado() != false) existTodoList.setRealizado(true);
        if (todo.getPrioridade() > 0) existTodoList.setPrioridade(todo.getPrioridade());

        Todo result = repository.save(existTodoList);
        return new RegisterTodoListDTO(result.getId(), result.getNome(), result.getDescricao(), result.getRealizado(), result.getPrioridade());
    }

    public void deleteTodoList(Long id) {
        repository.findById(id)
                        .orElseThrow(() -> new TodoNotFoundException(id));

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Error delete the todolist");
        }
    }
}
