# 🚀 Desafio Back-end - Java com Spring Boot

Este projeto é um desafio de back-end desenvolvido em **Java** utilizando **Spring Boot**, com as seguintes tecnologias e bibliotecas:

- **Spring Data JPA** (com Hibernate) para persistência
- **Bean Validation** para validação de dados
- **Lombok** para reduzir boilerplate de código
- **DTOs** para transferência de dados
- **Tratamento de Exceptions** customizado

---

## 📌 Estrutura do Projeto

O projeto segue uma arquitetura em camadas, organizada da seguinte forma:

- **Controller** → camada responsável por receber as requisições HTTP
- **Service** → camada que contém as regras de negócio
- **Repository** → camada de persistência de dados (com JPA/Hibernate)
- **Entity** → mapeamento das tabelas do banco
- **DTO** → objetos de transferência de dados
- **Exceptions** → tratamento de erros de forma customizada

---

## ✅ Tarefas do Desafio

- [x] Criar a **Entity**
- [x] Criar o **DTO**
- [x] Criar o **Repository**
- [x] Criar o **Service**
- [x] Criar as **Exceptions**
- [x] Criar a **Controller**

---

## 🚀 Como rodar o projeto

### Pré-requisitos
- Java 17+
- Maven 3+
- Banco de dados configurado (ex.: H2, PostgreSQL, MySQL)

### Passos
```bash
# Clone o repositório
git clone https://github.com/Tsoaresaz/todolist-with-spring-boot

# Entre na pasta do projeto
cd seu-repo

# Execute o projeto
mvn spring-boot:run
