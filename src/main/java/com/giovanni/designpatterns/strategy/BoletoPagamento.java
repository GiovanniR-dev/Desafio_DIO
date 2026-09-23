package com.giovanni.designpatterns.strategy;

import com.giovanni.designpatterns.entity.Pedido;
import com.giovanni.designpatterns.entity.StatusPedido;
import org.springframework.stereotype.Component;

@Component
public class BoletoPagamento implements PagamentoStrategy {
    public String tipo() { return "BOLETO"; }
    public void pagar(Pedido pedido) { pedido.setStatus(StatusPedido.PAGO); }
}
