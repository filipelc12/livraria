package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vitrine {


    private Long id;

    private List<Livro> livros = new ArrayList<>();

    public Vitrine(List<Livro> livros) {

        this.livros = livros;
    }

}
