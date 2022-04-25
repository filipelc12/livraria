package br.com.mentoria.livraria.service;

import br.com.mentoria.livraria.service.dto.AlterarAutorDto;
import br.com.mentoria.livraria.service.dto.AutorDto;
import br.com.mentoria.livraria.service.dto.CriarAutorDto;

public interface IAutorService {

    AutorDto salvarAutor(CriarAutorDto criarAutorDto);
    AutorDto alterarAutor(AlterarAutorDto alterarAutorDto);


}
