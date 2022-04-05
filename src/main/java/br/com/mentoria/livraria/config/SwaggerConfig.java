package br.com.mentoria.livraria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.mentoria.livraria"))
                .paths(regex("/vitrine.*"))
                .build();

    }


    private ApiInfo metaInfo(){

        ApiInfo apiInfo = new ApiInfo(
                "Venda Livros API REST",
                "Teste de swagger",
                "1.0",
                "Terms of Service",
                new Contact("Filipe", "www.google.com","filipelc12@gmail.com"),
                "Apache license Version",
                "www.apache.org/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }


}
