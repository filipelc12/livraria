package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull
    private String nome;

    @Column(name = "resumo", length = 100, nullable = false)
    @NotNull
    private String resumo;

    @Column(name = "sumario", length = 100, nullable = false)
    @NotNull
    private String sumario;

    @Column(name = "preco", length = 100, nullable = false)
    @NotNull
    private Double preco;

    @Column(name = "paginas", length = 100, nullable = false)
    @NotNull
    private Long paginas;

    @Column(name = "isbn", length = 14, nullable = false)
    @NotNull
    private String isbn;

    @Column(name = "dataEstreia", length = 12, nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataEstreia = LocalDate.now();

    //@Column(name = "categoria", length = 100, nullable = false)
    @NotNull
    @ManyToOne
    private Categoria categoria;

    //@Column(name = "autor", length = 100, nullable = false)
    @NotNull
    @ManyToOne
    private Autor autor;


    public Livro (String nome, String resumo, String sumario, Double preco, Long paginas, String isbn, Autor autor, Categoria categoria){
        this.nome = nome;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
    }

}


