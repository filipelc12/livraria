package br.com.mentoria.livraria.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErroDeFormularioDto {

    private String campo;
    private String mensagem;



}
