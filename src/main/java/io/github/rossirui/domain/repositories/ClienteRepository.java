package io.github.rossirui.domain.repositories;

import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
