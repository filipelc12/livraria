package br.com.mentoria.livraria.repository;

import br.com.mentoria.livraria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT t FROM Categoria t WHERE t.nome = :tipoCategoria ")
    Categoria findByNomeCategoria(String tipoCategoria);


}
