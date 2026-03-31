# FinanceTrack — API
 
API REST do FinanceTrack, uma aplicação de controle financeiro pessoal. Desenvolvida com Spring Boot, autenticação via JWT e banco de dados PostgreSQL.
 
---
 
## Base URL (Produção)
 
```
https://finance-track-api-6n9c.onrender.com
```
 
---
 
## Funcionalidades
 
- Cadastro e autenticação de usuários com JWT
- CRUD de receitas (income) e despesas (expenses)
- Gerenciamento de categorias por usuário
- Dashboard com saldo, totais e resumo por categoria
- Segurança por rotas com Spring Security
- Documentação automática via Swagger/OpenAPI
 
---
 
## Tecnologias
 
| Tecnologia | Descrição |
|---|---|
| Java 21 | Linguagem principal |
| Spring Boot | Framework web |
| Spring Security | Autenticação e autorização |
| Spring Data JPA | Persistência de dados |
| PostgreSQL | Banco de dados relacional |
| JWT (jjwt) | Tokens de autenticação |
| Lombok | Redução de boilerplate |
| Docker | Containerização da aplicação |
| Docker Cloud | Deploy e orquestração em nuvem |
| SpringDoc OpenAPI | Documentação Swagger |
 
---
 
## Estrutura do Projeto
 
```
src/main/java/br/com/brunootavio/finance_track/
├── controller/
│   ├── AuthController.java         # Endpoint de login
│   ├── UserController.java         # Cadastro de usuários
│   ├── ExpenseController.java      # CRUD de despesas
│   ├── IncomeController.java       # CRUD de receitas
│   ├── CategoryController.java     # CRUD de categorias
│   └── DashboardController.java    # Resumo financeiro
├── service/
│   ├── AuthService.java
│   ├── UserService.java
│   ├── ExpenseService.java
│   ├── IncomeService.java
│   ├── CategoryService.java
│   ├── DashboardService.java
│   ├── JwtService.java
│   └── SecurityService.java
├── model/
│   ├── User.java
│   ├── Expense.java
│   ├── Income.java
│   └── Category.java
├── dto/
│   ├── LoginRequestDTO.java
│   ├── UserRequestDTO.java / UserResponseDTO.java
│   ├── ExpenseRequestDTO.java / ExpenseResponseDTO.java
│   ├── IncomeRequestDTO.java / IncomeResponseDTO.java
│   ├── CategoryRequestDTO.java / CategoryResponseDTO.java
│   ├── DashboardResponseDTO.java
│   ├── CategorySummaryDTO.java
│   └── TransactionDTO.java
├── security/
│   ├── SecurityConfig.java         # Configuração CORS e filtros
│   └── JwtFilter.java              # Filtro de autenticação JWT
├── exception/
│   └── BusinessException.java
│   └── ResouceNotFoundException.java
│   └── UnauthorizedException.java
├── handler/
│   └── GlobalExceptionHandler.java
└── repository/
    ├── UserRepository.java
    ├── ExpenseRepository.java
    ├── IncomeRepository.java
    └── CategoryRepository.java
```
 
---
 
## Endpoints
 
### Auth
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/auth/login` | Realiza login e retorna JWT | ❌ |
 
### Usuário
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/user` | Cadastra novo usuário | ❌ |
 
### Despesas
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/expense` | Cria uma despesa | ✅ |
| GET | `/expense` | Lista despesas do usuário | ✅ |
| DELETE | `/expense/{id}` | Remove uma despesa | ✅ |
 
### Receitas
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/income` | Cria uma receita | ✅ |
| GET | `/income` | Lista receitas do usuário | ✅ |
 
### Categorias
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/category` | Cria uma categoria | ✅ |
| GET | `/category` | Lista categorias do usuário | ✅ |
| DELETE | `/category/{id}` | Remove uma categoria | ✅ |
 
### Dashboard
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| GET | `/dashboard` | Retorna saldo, totais e gastos por categoria | ✅ |
 
---
 
## Autenticação
 
A API usa **JWT Bearer Token**. Após o login, inclua o token no header de todas as requisições autenticadas:
 
```
Authorization: Bearer <seu_token>
```
 
---
 
## Como rodar localmente
 
### Pré-requisitos
 
- Java 21+
- Maven
- PostgreSQL rodando localmente
 
### Configuração do banco
 
Crie um banco de dados PostgreSQL:
 
```sql
CREATE DATABASE finance_track;
```
 
### Variáveis de ambiente
 
Configure as seguintes variáveis no seu ambiente ou em `application.properties`:
 
```
DB_URL=jdbc:postgresql://localhost:5432/finance_track
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
FRONTEND_URL=http://localhost:5173
```
 
### Executando
 
```bash
# Clone o repositório
git clone https://github.com/Brunootavioliveira/finance-track-api.git
cd finance-track-api
 
# Compile e rode
./mvnw spring-boot:run
```
 
A API estará disponível em `http://localhost:8080`.
 
---
 
## Documentação Swagger
 
Com a aplicação rodando localmente, acesse:
 
```
http://localhost:8080/swagger-ui/index.html
```
 
Ou acesse a documentação em produção:
 
```
https://finance-track-api-6n9c.onrender.com/swagger-ui/index.html
```
 
---
 
## Deploy
 
O deploy é feito via **Render**. As variáveis de ambiente são configuradas diretamente no painel do Render.
 
---
 
## Repositório do Frontend
 
[github.com/Brunootavioliveira/finance-track-frontend](https://github.com/Brunootavioliveira/finance-track-frontend)
 
---
 
## Autor
 
**Bruno Otavio Oliveira**  
[github.com/Brunootavioliveira](https://github.com/Brunootavioliveira) <br>
[LinkedIn.com/bruno-otavio/](https://www.linkedin.com/in/bruno-otavio/)
