package com.giovanni.designpatterns.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private String formaPagamento;
    private LocalDateTime criadoEm;

    public Pedido() {}

    public Pedido(String cliente, BigDecimal valor, String formaPagamento) {
        this.cliente = cliente;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.status = StatusPedido.CRIADO;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId(){ return id; }
    public String getCliente(){ return cliente; }
    public BigDecimal getValor(){ return valor; }
    public StatusPedido getStatus(){ return status; }
    public String getFormaPagamento(){ return formaPagamento; }
    public LocalDateTime getCriadoEm(){ return criadoEm; }
    public void setStatus(StatusPedido status){ this.status = status; }
}
