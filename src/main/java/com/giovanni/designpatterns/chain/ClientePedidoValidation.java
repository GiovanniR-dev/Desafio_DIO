package com.giovanni.designpatterns.chain;

import com.giovanni.designpatterns.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class ClientePedidoValidation implements ValidacaoPedido {
    public void validar(Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().isBlank())
            throw new IllegalArgumentException("Cliente é obrigatório.");
    }
}
