package br.com.mentoria.livraria.controller;

import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.model.Vitrine;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class VitrineController {

    @RequestMapping("/vitrine")
    public List<Livro> lista(){
        Livro livro =  new Livro("Livro teste", 44.5, LocalDate.parse("2020-12-01"));

        return Arrays.asList(livro,livro,livro);

    }


}
