package io.github.rossirui.domain.services;

import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.repositories.CategoriaRepository;
import io.github.rossirui.domain.services.exceptions.LocalObjectNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new LocalObjectNotFoudException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }

    public Categoria inserir(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria atualizar(Categoria obj) {
        buscarPorId(obj.getId());
        return categoriaRepository.save(obj);
    }
}
