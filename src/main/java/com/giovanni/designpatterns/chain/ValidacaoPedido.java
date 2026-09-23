package com.giovanni.designpatterns.chain;

import com.giovanni.designpatterns.entity.Pedido;

public interface ValidacaoPedido {
    void validar(Pedido pedido);
}
