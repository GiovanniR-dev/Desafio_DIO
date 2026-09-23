package com.giovanni.designpatterns.strategy;

import com.giovanni.designpatterns.entity.Pedido;

public interface PagamentoStrategy {
    String tipo();
    void pagar(Pedido pedido);
}
