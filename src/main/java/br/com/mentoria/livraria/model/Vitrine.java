/*
package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vitrine")
public class Vitrine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
  //  @OneToMany
    private List<Livro> livros = new ArrayList<>(); //todo ver essa m* aqui

    public Vitrine(List<Livro> livros) {

        this.livros = livros;
    }


}
*/