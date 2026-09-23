package com.giovanni.designpatterns.repository;

import com.giovanni.designpatterns.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
