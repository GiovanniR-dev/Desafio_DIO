package com.giovanni.designpatterns.strategy;

import com.giovanni.designpatterns.entity.Pedido;
import com.giovanni.designpatterns.entity.StatusPedido;
import org.springframework.stereotype.Component;

@Component
public class PixPagamento implements PagamentoStrategy {
    public String tipo() { return "PIX"; }
    public void pagar(Pedido pedido) { pedido.setStatus(StatusPedido.PAGO); }
}
