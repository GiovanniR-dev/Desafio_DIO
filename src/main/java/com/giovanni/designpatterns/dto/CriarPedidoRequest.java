package com.giovanni.designpatterns.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CriarPedidoRequest(
    @NotBlank(message = "Cliente é obrigatório") String cliente,
    @NotNull @Positive(message = "Valor deve ser maior que zero") BigDecimal valor,
    @NotBlank(message = "Forma de pagamento é obrigatória") String formaPagamento
) {}
