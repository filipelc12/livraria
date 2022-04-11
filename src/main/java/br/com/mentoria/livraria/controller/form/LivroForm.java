package br.com.mentoria.livraria.controller.form;

import br.com.mentoria.livraria.model.Autor;
import br.com.mentoria.livraria.model.Categoria;
import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.repository.AutorRepository;
import br.com.mentoria.livraria.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroForm {

    @NotNull @Size(min = 3)
    private String titulo;
    @NotNull @Size(min = 15)
    private String resumo;
    private String sumario;
    @NotNull @Min(value = 1)
    private Double preco;
    @NotNull
    private Long paginas;
    @NotNull @Size(min = 13, max = 13)
    private String isbn;
    @NotNull
    private String nomeAutor;
    @NotNull
    private String tipoCategoria;


    public Livro converter(AutorRepository autorRepository, CategoriaRepository nomeCategoria) {
        Autor autor = autorRepository.findByNome(nomeAutor);
        Categoria categoria = nomeCategoria.findByNomeCategoria(tipoCategoria);


        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, autor, categoria);

    }
}
