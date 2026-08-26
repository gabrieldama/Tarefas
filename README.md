# DOJO - TAREFA
## Estrutura do projeto

```
src/main/java/com/concessionaria
 config/       -> configuração do Swagger/OpenAPI
 controller/   -> endpoints da API (Tarefa/Categoria/Usuario)
 model/        -> entidades JPA (Tarefa/Categoria/Usuario)
 repository/   -> interfaces JpaRepository de acesso ao banco
```

## Como rodar o projeto

### Pré-requisitos
- Java 21 instalado
- MySQL rodando na sua máquina (ou em container)

### Passo a passo

1. O projeto cria o banco de dados sozinho, então n precisa se preocupar
2. Verifique o nome e senha do banco (por padrão está `root` / `root`).
3. Rode o projeto com o Maven Wrapper, direto na pasta do projeto:
```bash
 ./mvnw spring-boot:run
```
4. acessar: `http://localhost:8080`
5. Swagger: `http://localhost:8080/swagger-ui.html`

## Endpoints principais

### Tarefa (`/api/tarefas`)
- /api/tarefas/Cadastrar - cadastra nova tarefa (post)
- /api/tarefas/Listar - lista todas as tarefas (get)
- /api/tarefas/Listar/{id} - busca pelo id da tarefa (get)
- /api/tarefas/Atualizar/{id} - atualiza a tarefa (put)
- /api/tarefas/Excluir/{id} - exclui a tarefa  (delete)

### Tarefa (`/api/categoria`)
- /api/tarefas/Cadastrar - cadastra nova categoria (post)
- /api/tarefas/Listar - lista todas as categorias (get)
- /api/tarefas/Listar/{id} - busca pelo id da categoria (get)
- /api/tarefas/Atualizar/{id} - atualiza a categoria (put)
- /api/tarefas/Excluir/{id} - exclui a categoria (delete)

### Tarefa (`/api/usuario`)
- /api/tarefas/Cadastrar - cadastra novo usuario (post)
- /api/tarefas/Listar - lista todos os usuarios (get)
- /api/tarefas/Listar/{id} - busca pelo id do usuario (get)

## Contribuições

### Gabriel
- Configuração de Application.yaml
- Criação de CRUD Categoria completo
- Estruturação inicial do projeto
- Criação das Models
- Configuração da CategoriaController

### Leonardo
- Configuração das exceptions (recursoNaoEncontrado e emailJaCadastrado)
- Configuração da GlobalExceptionHandler
- Configuração das controllers (TarefaController e UsuarioController)
- Criação e configuração dos DTOs (ErroResponse e TarefaRequest)
- Criação e configuração da service (TarefaService)

### Thiago 
- Configuração e criação das repositories
- Criação e configuração das services (UsuarioService e CategoriaService)
- Configuração das models e relacionamentos entre tabelas
- README.md
- Configuração parcial do Swagger
- Correção nome de metodos e endpoints
