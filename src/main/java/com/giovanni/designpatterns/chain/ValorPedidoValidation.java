package com.giovanni.designpatterns.chain;

import com.giovanni.designpatterns.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class ValorPedidoValidation implements ValidacaoPedido {
    public void validar(Pedido pedido) {
        if (pedido.getValor() == null || pedido.getValor().signum() <= 0)
            throw new IllegalArgumentException("Valor do pedido deve ser maior que zero.");
    }
}
