package br.com.mentoria.livraria.controller;

import br.com.mentoria.livraria.model.Autor;
import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.repository.AutorRepository;
import br.com.mentoria.livraria.service.IAutorService;
import br.com.mentoria.livraria.service.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "API REST autores")
@CrossOrigin(origins = "*")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private IAutorService autorService;

    @RequestMapping(value = "/autor", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna lista de autores")
    public List<AutorDto> lista(String nomeAutor) {
        if (nomeAutor == null) {
            List<Autor> autores = autorRepository.findAll();
            return AutorDto.converter(autores);
        }else{
            List<Autor> autores = autorRepository.findAutorByNome(nomeAutor);
            return AutorDto.converter(autores);
        }
    }

    // TODO: 22/04/2022 ao deletar um autor q está sendo utilizado em um livro, ocorre um erro no banco de dados 
    @RequestMapping(value = "/autor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable("id") Long id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            autorRepository.delete(autor.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Metodo GET para autor")
    public ResponseEntity<AutorDto> detalhar(@PathVariable("id") Long id){
        // TODO: 13/04/2022 Refatorar para criar um metodo obterPorId no livroService convertendo a entidade livro no livroDto
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()){
            AutorDto autorDto = new AutorDto(autor.get());
            return new ResponseEntity(autorDto, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/autor/{id}", method = RequestMethod.PUT)
    @ApiOperation("Metodo PUT para autor")
    public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AlterarAutorDto alterarAutorDto){
        alterarAutorDto.setId(id);
        AutorDto autorDto = autorService.alterarAutor(alterarAutorDto);
        return new ResponseEntity(autorDto, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/autor", method = RequestMethod.POST)
    @ApiOperation(value = "Metodo POST para autores")
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid CriarAutorDto form){
        AutorDto autorDto = autorService.salvarAutor(form);
        return new ResponseEntity(autorDto, HttpStatus.CREATED);

    }



}
