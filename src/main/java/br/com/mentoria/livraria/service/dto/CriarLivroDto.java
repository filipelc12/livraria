package br.com.mentoria.livraria.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarLivroDto {

    @NotNull
    private String titulo;
    private String resumo;
    private String sumario;
    @Min(20)
    private Double preco;
    private Long paginas;
    //@Size(min = 13, max =13)
    private String isbn;
    private String nomeAutor;
    private String tipoCategoria;
}
