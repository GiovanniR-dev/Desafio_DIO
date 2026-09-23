package com.giovanni.designpatterns.dto;

import com.giovanni.designpatterns.entity.Pedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResponse(Long id, String cliente, BigDecimal valor, String status,
                              String formaPagamento, LocalDateTime criadoEm) {
    public static PedidoResponse from(Pedido p) {
        return new PedidoResponse(p.getId(), p.getCliente(), p.getValor(),
                p.getStatus().name(), p.getFormaPagamento(), p.getCriadoEm());
    }
}
