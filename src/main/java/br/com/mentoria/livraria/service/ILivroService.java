package br.com.mentoria.livraria.service;

import br.com.mentoria.livraria.service.dto.AlterarLivroDto;
import br.com.mentoria.livraria.service.dto.LivroDto;
import br.com.mentoria.livraria.service.dto.CriarLivroDto;

public interface ILivroService {

    LivroDto salvarLivro(CriarLivroDto criarLivroDto);
    LivroDto alterarLivro(AlterarLivroDto alterarLivroDto);

}
