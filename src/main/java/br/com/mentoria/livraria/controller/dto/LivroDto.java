package br.com.mentoria.livraria.controller.dto;

import br.com.mentoria.livraria.model.Livro;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LivroDto {

    private Long id;
    private String nome;
    private String resumo;
    private Double preco;
    private String autor;
    private String dataEstreia;

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
