# API de Pedidos — Design Patterns

Projeto desenvolvido em Java 21 + Spring Boot para demonstrar Design Patterns clássicos do GoF e recursos de inversão de controle do Spring.

## Patterns utilizados

- **Strategy:** cada forma de pagamento possui uma implementação própria.
- **Factory:** `PagamentoFactory` escolhe a estratégia de pagamento.
- **Chain of Responsibility:** validações são executadas por uma cadeia de componentes.
- **Repository:** Spring Data JPA abstrai a persistência.
- **Dependency Injection:** o Spring injeta as dependências das classes.

## Tecnologias

Java 21, Spring Boot, Spring Web, Spring Data JPA, Bean Validation e H2.

## Executar

```bash
mvn spring-boot:run
```

API: `http://localhost:8080`

## Endpoints

### Criar pedido
`POST /api/pedidos`

```json
{
  "cliente": "Giovanni",
  "valor": 199.90,
  "formaPagamento": "PIX"
}
```

Formas aceitas: `PIX`, `CARTAO`, `BOLETO`.

### Listar
`GET /api/pedidos`

### Buscar
`GET /api/pedidos/{id}`

### Pagar
`PATCH /api/pedidos/{id}/pagar`

### Cancelar
`PATCH /api/pedidos/{id}/cancelar`

## Objetivo

O foco deste projeto é demonstrar como padrões de projeto podem reduzir acoplamento e organizar regras de negócio em uma aplicação Spring Boot.
