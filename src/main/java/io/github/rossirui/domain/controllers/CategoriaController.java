package io.github.rossirui.domain.controllers;

import io.github.rossirui.domain.dto.CategoriaDTO;
import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Categoria obj) {
        obj = categoriaService.inserir(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Categoria obj, @PathVariable Integer id) {
        obj.setId(id);
        categoriaService.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> buscar() {
        List<Categoria> lista = categoriaService.buscar();
        List<CategoriaDTO> listaDTO = lista
                .stream()
                .map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

}
