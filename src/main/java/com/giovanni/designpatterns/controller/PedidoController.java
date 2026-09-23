package com.giovanni.designpatterns.controller;

import com.giovanni.designpatterns.dto.CriarPedidoRequest;
import com.giovanni.designpatterns.dto.PedidoResponse;
import com.giovanni.designpatterns.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse criar(@Valid @RequestBody CriarPedidoRequest request) {
        return PedidoResponse.from(service.criar(request));
    }

    @GetMapping
    public List<PedidoResponse> listar() {
        return service.listar().stream().map(PedidoResponse::from).toList();
    }

    @GetMapping("/{id}")
    public PedidoResponse buscar(@PathVariable Long id) {
        return PedidoResponse.from(service.buscar(id));
    }

    @PatchMapping("/{id}/pagar")
    public PedidoResponse pagar(@PathVariable Long id) {
        return PedidoResponse.from(service.pagar(id));
    }

    @PatchMapping("/{id}/cancelar")
    public PedidoResponse cancelar(@PathVariable Long id) {
        return PedidoResponse.from(service.cancelar(id));
    }
}
