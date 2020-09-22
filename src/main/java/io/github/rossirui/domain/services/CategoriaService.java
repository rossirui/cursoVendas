package io.github.rossirui.domain.services;

import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.repositories.CategoriaRepository;
import io.github.rossirui.domain.services.exceptions.LocalDataIntegrityViolationException;
import io.github.rossirui.domain.services.exceptions.LocalObjectNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void deletar(Integer id) {
        buscarPorId(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new LocalDataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos.");
        }
    }
    public List<Categoria> buscar() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> buscarPagina(Integer pagina, Integer linhasPorPagina, String direcao, String ordenarPor) {
        PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Sort.Direction.valueOf(direcao), ordenarPor);
        return categoriaRepository.findAll(pageRequest);
    }

}
