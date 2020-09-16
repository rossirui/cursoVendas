package io.github.rossirui.domain.services;

import io.github.rossirui.domain.entities.Pedido;
import io.github.rossirui.domain.repositories.PedidoRepository;
import io.github.rossirui.domain.services.exceptions.LocalObjectNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new LocalObjectNotFoudException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Pedido.class.getName()));
    }
}
