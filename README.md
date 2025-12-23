### Desafio Técnico Dev. Júnior – Mini Catálogo (Produto & Categoria)

## 1. Requisitos Técnicos

- Spring Boot
- Spring Web
- Spring Data JPA
- Banco H2 em memória
- Console acessível via /h2-console

## 1.1. Camadas obrigatórias

- controller
- repository
- Sem DTO
- Usar entidades diretamente no JSON (@RequestBody)
- Popular dados iniciais usando CommandLineRunner

### 2. Modelagem

## 2.1. Entidade Categoria

Campos:
{ id, nome }

## 2.2. Entidade Produto

Campos:
{ id, nome, preco, categoria }

## 2.3. Relacionamento

- Uma Categoria possui vários Produtos
- Um Produto pertence a uma Categoria
- Relacionamento: @OneToMany / @ManyToOne

### 3. Endpoints Obrigatórios

## 3.1. Criar Categoria

```CODE
POST /categorias
Exemplo de Body
{ "nome": "Informática" }


Resposta: 201 Created

3.2. Listar Categorias
GET /categorias

```

## 3.3. Criar Produto Vinculado a Categoria

Escolha UMA das formas:

```CODE
POST /produtos?categoriaId={id}

ou

POST /categorias/{id}/produtos

Exemplo de Body

{
  "nome": "Mouse Logitech",
  "preco": 120.0
}

Regras

Categoria inexistente → 404 Not Found
Criado com sucesso → 201 Created
```


## 3.4. Listar Produtos de uma Categoria

```
- GET /categorias/{id}/produtos

Categoria inexistente → 404 Not Found
Categoria existente → 200 OK
```

## 3.5. Listar Todos os Produtos

```
GET /produtos

Resposta: 200 OK
```

### 4. Regras de Resposta

- Usar obrigatoriamente ResponseEntity
- Em criação → 201 Created
- Em busca com sucesso → 200 OK
- Para IDs inexistentes → 404 Not Found

### 5. Seed Inicial (CommandLineRunner)

- Criar carga inicial com: Pelo menos 2 categorias

Pelo menos 3 produtos distribuídos entre elas

O seed deve rodar automaticamente ao iniciar a aplicação.