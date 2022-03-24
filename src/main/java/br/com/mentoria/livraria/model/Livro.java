package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro {

    private Long id;
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


    public Livro (String nome, Double preco, LocalDate dataEstreia){
        this.nome = nome;
        this.preco = preco;
        this.dataEstreia = dataEstreia;
    }

}


