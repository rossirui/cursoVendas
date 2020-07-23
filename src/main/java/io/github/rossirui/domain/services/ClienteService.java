package io.github.rossirui.domain.services;

import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.entities.Cliente;
import io.github.rossirui.domain.repositories.ClienteRepository;
import io.github.rossirui.domain.services.exceptions.LocalObjectNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new LocalObjectNotFoudException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }

}
