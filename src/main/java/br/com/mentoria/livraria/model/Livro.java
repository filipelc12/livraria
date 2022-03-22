package br.com.mentoria.livraria.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class Livro {

    @NotEmpty
    private String nome;
    private String resumo;
    private String sumario;
    private Double preco;
    private Long paginas;
    private String isbn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataEstreia;
    private Categoria categoria;
    private Autor autor;

    public Livro (String nome, String resumo, String sumario, Double preco, Long paginas, String isbn, LocalDate dataEstreia, Categoria categoria, Autor autor) {
        this.nome = nome;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataEstreia = dataEstreia;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro (String nome, Double preco, LocalDate dataEstreia){
        this.nome = nome;
        this.preco = preco;
        this.dataEstreia = dataEstreia;
    }

    public String getNome() {
        return nome;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Long getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataEstreia() {
        return dataEstreia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}


