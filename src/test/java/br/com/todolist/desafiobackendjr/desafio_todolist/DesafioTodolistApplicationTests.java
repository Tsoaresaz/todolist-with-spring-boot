package br.com.todolist.desafiobackendjr.desafio_todolist;

import br.com.todolist.desafiobackendjr.desafio_todolist.v1.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
        var todo = new Todo("todo 1", "description test todo 1", false, 1);

        webTestClient
                .post()
                .uri("/v1/api/todolist")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.nome").isEqualTo(todo.getNome())
                .jsonPath("$.descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$.realizado").isEqualTo(todo.getRealizado())
                .jsonPath("$.prioridade").isEqualTo(todo.getPrioridade());

	}

    @Test
    void testCreateTodoFailure() {
        var todo = new Todo("", "", false, 1);

        webTestClient
                .post()
                .uri("/v1/api/todolist")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isBadRequest();
    }

}
