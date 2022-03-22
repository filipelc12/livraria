package br.com.mentoria.livraria.model;

import java.util.ArrayList;
import java.util.List;

public class Vitrine {

    private List<Livro> livros = new ArrayList<>();

    public Vitrine(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
