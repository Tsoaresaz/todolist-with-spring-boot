package br.com.todolist.desafiobackendjr.desafio_todolist.v1.repository;

import br.com.todolist.desafiobackendjr.desafio_todolist.v1.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
