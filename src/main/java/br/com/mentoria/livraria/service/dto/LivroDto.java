/*
Nas classes DTO eu vou colocar as anotações que quero que o sistema valide como notnull e min e max a nível de sistema

 */

package br.com.mentoria.livraria.service.dto;

import br.com.mentoria.livraria.model.Livro;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LivroDto {

    @NotNull
    private final Long id;
    @NotEmpty
    private final String nome;
    private final String resumo;
    @Min(20)
    private final Double preco;
    @NotNull
    private final String autor;
    private final String dataEstreia;

    public LivroDto(Livro livro){
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.resumo = livro.getResumo();
        this.preco = livro.getPreco();
        this.autor = livro.getAutor().getNome();
        this.dataEstreia = livro.getDataEstreia().toString();
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
