package com.giovanni.designpatterns.factory;

import com.giovanni.designpatterns.strategy.PagamentoStrategy;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PagamentoFactory {
    private final List<PagamentoStrategy> estrategias;

    public PagamentoFactory(List<PagamentoStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public PagamentoStrategy criar(String tipo) {
        return estrategias.stream()
                .filter(e -> e.tipo().equalsIgnoreCase(tipo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento inválida: " + tipo));
    }
}
