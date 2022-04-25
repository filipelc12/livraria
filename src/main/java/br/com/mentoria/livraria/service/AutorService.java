package br.com.mentoria.livraria.service;

import br.com.mentoria.livraria.model.Autor;
import br.com.mentoria.livraria.repository.AutorRepository;
import br.com.mentoria.livraria.service.dto.AlterarAutorDto;
import br.com.mentoria.livraria.service.dto.AutorDto;
import br.com.mentoria.livraria.service.dto.CriarAutorDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutorService implements IAutorService{

    private final AutorRepository autorRepository;

    @Override
    public AutorDto salvarAutor(CriarAutorDto criarAutorDto){
        Autor autor = new Autor(criarAutorDto.getNome(),
                                criarAutorDto.getDescricao(),
                                criarAutorDto.getEmail());

        autorRepository.save(autor);
        return new AutorDto(autor);
    }

    @Override
    public AutorDto alterarAutor(AlterarAutorDto alterarAutorDto){
        Autor autor = autorRepository.getById(alterarAutorDto.getId());

        autor.setNome(alterarAutorDto.getNome());
        autor.setDescricao(alterarAutorDto.getDescricao());
        autor.setEmail(alterarAutorDto.getEmail());

        autorRepository.save(autor);
        return new AutorDto(autor);

    }

}
