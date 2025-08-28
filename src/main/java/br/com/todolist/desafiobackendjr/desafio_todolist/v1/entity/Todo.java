package br.com.todolist.desafiobackendjr.desafio_todolist.v1.entity;


import br.com.todolist.desafiobackendjr.desafio_todolist.v1.dto.RegisterTodoListDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o nome da tarefa é obrigatório")
    @Size(max = 50, message = "O nome da tarefa deve ter no máximo 50 caracter")
    private String nome;

    @NotBlank(message = "É obrigatório ter uma descrição para a tarefa!")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracter")
    private String descricao;

    @Column(nullable = false)
    private Boolean realizado = false;

    @PositiveOrZero(message = "Não é aceite valores negativos")
    private Integer prioridade = 0;

    public Todo (String nome, String descricao, Boolean realizado, Integer prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public static Todo fromDTO(RegisterTodoListDTO dto) {
        Todo todo = new Todo();
        todo.setNome(dto.getNome());
        todo.setDescricao(dto.getDescricao());
        todo.setRealizado(dto.getRealizado());
        todo.setPrioridade(dto.getPrioridade());

        return todo;
    }
}
