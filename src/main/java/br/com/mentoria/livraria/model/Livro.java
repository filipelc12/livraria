/*
As validações (annotations) aqui presente são a nível de banco
 */

package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    //@Min(value = 20)
    private Double preco;

    @Column(name = "paginas", length = 100, nullable = false)
    @NotNull
    private Long paginas;

    //todo verificar o ponto sobre o banco de ISBN
    @Column(name = "isbn", nullable = false)
    @NotNull
    private String isbn;

    @Column(name = "dataEstreia", length = 12, nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataEstreia = LocalDate.now();

    @NotNull
    @ManyToOne
    private Categoria categoria;

   // @NotNull
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


