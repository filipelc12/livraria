package br.com.mentoria.livraria.service.dto;

import br.com.mentoria.livraria.model.Autor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AutorDto {

    @NotNull
    private Long id;
    @NotEmpty
    private String nome;
    @NotNull
    private String email;
    private String dataCriacao;
    private String descricao;

    public AutorDto(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.dataCriacao = autor.getDataCriacao().toString();
        this.descricao = autor.getDescricao();
    }


    public static List<AutorDto> converter(List<Autor> autores){
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
    }


}
