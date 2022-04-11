package br.com.mentoria.livraria.controller;

import br.com.mentoria.livraria.controller.dto.LivroDto;
import br.com.mentoria.livraria.controller.form.LivroForm;
import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.repository.AutorRepository;
import br.com.mentoria.livraria.repository.CategoriaRepository;
import br.com.mentoria.livraria.repository.VitrineRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Api(value = "API REST vitrine")
@CrossOrigin(origins = "*")
public class VitrineController {

    @Autowired
    private VitrineRepository vitrineRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(value = "/vitrine", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de livros")
    public List<LivroDto> lista(String nomeAutor){
        if (nomeAutor == null){
            List<Livro> livros = vitrineRepository.findAll();
            return LivroDto.converter(livros);

        }else{
            List<Livro> livros = vitrineRepository.findByAutorNome(nomeAutor);
            return LivroDto.converter(livros);
        }
    }

    @RequestMapping(value = "/vitrine", method = RequestMethod.POST)
    @ApiOperation(value = "Metodo POST para livros")
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuiler){
        Livro livro = form.converter(autorRepository, categoriaRepository);
        vitrineRepository.save(livro);
        System.out.println("Livro cadastrado");

        URI uri = uriBuiler.path("/topicos/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));


    }

    @RequestMapping(value = "/vitrine", method = RequestMethod.DELETE)
    public void deletar(){

    }


}
