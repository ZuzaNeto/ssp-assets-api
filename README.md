# 🛡️ SSP-Assets: Sistema de Gestão de Ativos Tecnológicos

Este projeto é uma API REST desenvolvida como parte do aprendizado em Spring Boot, seguindo arquitetura MVC, focada no controle, rastreabilidade e gestão de inventário de ativos tecnológicos (rádios digitais, notebooks, drones, terminais de rede, etc.).

O sistema permite que gestores de TI monitorem em quais departamentos (Delegacias, Institutos, Comandos) cada equipamento está alocado, garantindo integridade e histórico de movimentação. O Sistema foi desenvolvido para aprendizado mas pode ser implementado em órgãos públicos como a **Secretaria de Segurança Pública (SSP)**

---

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as melhores práticas de engenharia de software e arquitetura em camadas:

* **Java 17/21** & **Spring Boot 3**
* **Spring Data JPA**: Persistência de dados e consultas dinâmicas.
* **Spring Security**: Configuração de segurança e controle de acesso.
* **PostgreSQL**: Banco de dados relacional de alta confiabilidade.
* **Docker & Docker Compose**: Containerização de toda a infraestrutura de banco de dados.
* **Lombok**: Redução de código boilerplate.
* **Bean Validation**: Validação de integridade dos dados de entrada.

---

## 🛠️ Arquitetura e Decisões de Engenharia

O projeto segue o padrão de **Arquitetura em Camadas (N-Tier Architecture)**, garantindo a separação de responsabilidades:

1.  **Entities**: Mapeamento objeto-relacional (ORM) representando as tabelas do governo.
2.  **Repositories**: Camada de acesso aos dados com uso de *Query Methods* para filtros específicos.
3.  **Services**: Camada de regras de negócio e tratamento de exceções.
4.  **Controllers**: Endpoints REST que expõem os recursos da aplicação.
5.  **Exception Handling**: Centralizador de erros que transforma exceções internas em respostas JSON amigáveis (padrão RFC 7807).


## 🐳 Como Executar o Projeto

**Pré-requisitos**

* Docker e Docker Compose instalados.
* Java JDK 17 ou superior.
* IDE de sua preferência (IntelliJ recomendado).

Passo a Passo

1. **Subir o Banco de Dados:**
O projeto utiliza Docker para garantir que o banco esteja pronto com um comando:
```Bash
docker-compose up -d
```
_Nota: O banco está configurado na porta **5433** para evitar conflitos com instalações locais._


2. **Executar a Aplicação:**
Rode a classe DemoApplication através da sua IDE ou via terminal:
```Bash
mvnw spring-boot:run
```

3. **Acessar a API:**
A API estará disponível em ```http://localhost:8080```.

## 📍 Endpoints Principais

| Método | Endpoint | Descrição |
| :--- | :---: | ---: |
| GET | ```/ativos``` | Lista todos os equipamentos cadastrados no sistema. |
| GET | ```/ativos/{id}``` | Busca um ativo específico por ID (retorna 404 caso não exista). |
| POST | ```/ativos``` | Cadastra um novo ativo (necessário informar o ID do departamento no JSON). |
| GET | ```/ativos/buscar-por-departamento?deptoId=1``` | Filtra e lista todos os ativos vinculados a uma unidade específica. |
| PUT | ```/ativos/{id}``` | Atualiza informações de um ativo existente (ex: mudança de status). |
| DELETE | ```/ativos/{id}``` | Remove permanentemente o registro de um ativo do banco de dados. |
| GET | ```/departamentos``` | Lista todas as delegacias/setores cadastrados. |
| POST | ```/departamentos``` | Cadastra uma nova unidade da Secretaria de Segurança Pública. |

## 👨‍💻 Autor
José Nunes de Sousa Neto

Graduando em Engenharia de Computação - UFMA

Bacharel em Ciência e Tecnologia - UFMA
