package br.com.mentoria.livraria.controller;

import br.com.mentoria.livraria.service.dto.AlterarLivroDto;
import br.com.mentoria.livraria.service.dto.LivroDto;
import br.com.mentoria.livraria.service.dto.CriarLivroDto;
import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.repository.LivroRepository;
import br.com.mentoria.livraria.service.ILivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "API REST vitrine")
@CrossOrigin(origins = "*")
public class VitrineController {

    @Autowired
    private LivroRepository livroRepository;

//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Autowired
//    private CategoriaRepository categoriaRepository;

    @Autowired
    private ILivroService livroService;

    @RequestMapping(value = "/vitrine", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de livros")
    public List<LivroDto> lista(String nomeAutor){
        if (nomeAutor == null){
            List<Livro> livros = livroRepository.findAll();
            return LivroDto.converter(livros);

        }else{
            List<Livro> livros = livroRepository.findByAutorNomeContainsIgnoreCase(nomeAutor);
            return LivroDto.converter(livros);
        }
    }

    @RequestMapping(value = "/vitrine", method = RequestMethod.POST)
    @ApiOperation(value = "Metodo POST para livros")
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid CriarLivroDto form, UriComponentsBuilder uriBuiler){
        LivroDto livroDto = livroService.salvarLivro(form);
        return new ResponseEntity(livroDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vitrine/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable("id") Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()){
            livroRepository.delete(livro.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


    @RequestMapping(value = "/vitrine/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Metodo POST para livros")
    public ResponseEntity<LivroDto> detalhar(@PathVariable("id") Long id){
        // TODO: 13/04/2022 Refatorar para criar um metodo obterPorId no livroService convertendo a entidade livro no livroDto 
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()){
            LivroDto livroDto = new LivroDto(livro.get());
            return new ResponseEntity(livroDto, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }




    @RequestMapping(value = "/vitrine/{id}", method = RequestMethod.PUT)
    @ApiOperation("Metodo PUT")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AlterarLivroDto alterarLivroDto){
        alterarLivroDto.setId(id);
        LivroDto livroDto = livroService.alterarLivro(alterarLivroDto);
        return new ResponseEntity(livroDto, HttpStatus.ACCEPTED);

    }


}
