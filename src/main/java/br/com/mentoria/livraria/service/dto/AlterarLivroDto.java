package br.com.mentoria.livraria.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlterarLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private String nomeAutor;
    private String tipoCategoria;
}
