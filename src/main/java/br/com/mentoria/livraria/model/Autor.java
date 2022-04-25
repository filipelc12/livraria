package br.com.mentoria.livraria.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "autor")
public class Autor  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(message = "Nome não pode ser null")
    private String nome;

    @Column(name = "email", length = 100, nullable = false)
    @NotNull(message = "Email não pode ser null")
    private String email;

    @Column(name = "data_de_criacao", length = 12, nullable = false)
    @NotNull(message = "Data de criação não pode ser null")
    private LocalDate dataCriacao = LocalDate.now();

    @Column(name = "descricao", length = 255, nullable = false)
    @NotNull(message = "Descrição não pode ser null")
    private String descricao;


    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}