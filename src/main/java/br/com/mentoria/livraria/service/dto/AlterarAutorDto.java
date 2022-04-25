package br.com.mentoria.livraria.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlterarAutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;

}
