package br.com.todolist.desafiobackendjr.desafio_todolist.v1.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterTodoListDTO {

    @Id
    private Long id;

    @NotBlank(message = "o nome da tarefa é obrigatório")
    @Size(max = 50, message = "O nome da tarefa deve ter no máximo 50 caracter")
    private String nome;

    @NotBlank(message = "É obrigatório ter uma descrição para a tarefa!")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracter")
    private String descricao;

    private Boolean realizado = false;

    @PositiveOrZero(message = "Não é aceite valores negativos")
    private Integer prioridade = 0;

}
