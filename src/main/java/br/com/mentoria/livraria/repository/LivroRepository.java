package br.com.mentoria.livraria.repository;

import br.com.mentoria.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorNomeContainsIgnoreCase(String nomeAutor);
}
