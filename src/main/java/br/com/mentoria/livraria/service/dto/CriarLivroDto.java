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
public class CriarLivroDto {


    private String titulo;
    private String resumo;
    private String sumario;
    @Min(20)
    private Double preco;
    private Long paginas;
    //@Size(min = 13, max =13)
    private String isbn;
    @NotNull
    private String nomeAutor;
    private String tipoCategoria;
}
