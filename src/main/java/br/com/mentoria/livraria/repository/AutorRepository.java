package br.com.mentoria.livraria.repository;

import br.com.mentoria.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String nomeAutor);
}
