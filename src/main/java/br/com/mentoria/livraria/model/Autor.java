package br.com.mentoria.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    private Long id;
    private String nome;
    @Email
    @NotEmpty
    private String email;
    @Size(max = 300)
    private String descricao;
    private LocalDateTime registro = LocalDateTime.now();

    public Autor(String email, String nome, String descricao){
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;

    }


}
