package br.com.mentoria.livraria.service.dto;

import br.com.mentoria.livraria.model.Autor;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarAutorDto {

    private String nome;
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$")
    @Email
    private String email;
    private String descricao;


}
