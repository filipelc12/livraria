package br.com.mentoria.livraria.controller;

import br.com.mentoria.livraria.controller.dto.LivroDto;
import br.com.mentoria.livraria.model.Autor;
import br.com.mentoria.livraria.model.Categoria;
import br.com.mentoria.livraria.model.Livro;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "API REST vitrine")
@CrossOrigin(origins = "*")
public class VitrineController {

    @RequestMapping("/vitrine")
    @ApiOperation(value = "Retorna uma lista de livros")
    public List<LivroDto> lista(){
        Autor autor = new Autor(1L, "teste@gmail.com", "TesteAutor",LocalDate.now(),"teste");
        Categoria categoria = new Categoria(2L, "TesteCategoria");
        Livro livro =  new Livro(1L,"TesteNomeLivro", "Teste resumo", "Teste Sumario", 10.5,450L,"100589945",LocalDate.parse("2021-10-02"),categoria,autor);

        return LivroDto.converter(Arrays.asList(livro,livro,livro));

    }


}
