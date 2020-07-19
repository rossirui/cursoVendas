package io.github.rossirui;

import io.github.rossirui.domain.entities.Categoria;
import io.github.rossirui.domain.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoVendasApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoVendasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(null, "Informática");
        Categoria categoria2 = new Categoria(null, "Escritório");

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
    }
}
