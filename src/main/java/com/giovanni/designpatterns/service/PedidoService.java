package com.giovanni.designpatterns.service;

import com.giovanni.designpatterns.chain.ValidacaoPedido;
import com.giovanni.designpatterns.dto.CriarPedidoRequest;
import com.giovanni.designpatterns.entity.Pedido;
import com.giovanni.designpatterns.factory.PagamentoFactory;
import com.giovanni.designpatterns.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final PagamentoFactory pagamentoFactory;
    private final List<ValidacaoPedido> validacoes;

    public PedidoService(PedidoRepository repository, PagamentoFactory pagamentoFactory,
                         List<ValidacaoPedido> validacoes) {
        this.repository = repository;
        this.pagamentoFactory = pagamentoFactory;
        this.validacoes = validacoes;
    }

    public Pedido criar(CriarPedidoRequest request) {
        Pedido pedido = new Pedido(request.cliente(), request.valor(), request.formaPagamento());
        validacoes.forEach(v -> v.validar(pedido));
        return repository.save(pedido);
    }

    public Pedido pagar(Long id) {
        Pedido pedido = buscar(id);
        pagamentoFactory.criar(pedido.getFormaPagamento()).pagar(pedido);
        return repository.save(pedido);
    }

    public Pedido buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado: " + id));
    }

    public List<Pedido> listar() { return repository.findAll(); }

    public Pedido cancelar(Long id) {
        Pedido pedido = buscar(id);
        pedido.setStatus(com.giovanni.designpatterns.entity.StatusPedido.CANCELADO);
        return repository.save(pedido);
    }
}
