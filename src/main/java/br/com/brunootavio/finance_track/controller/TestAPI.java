package br.com.brunootavio.finance_track.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //é uma anotação do Spring Boot que diz: "Essa classe vai receber requisições HTTP e devolver respostas em formato JSON (normalmente)."
@RequestMapping("/hello") //endpoint
public class TestAPI {

    @GetMapping
    public String hello() {
        return "API rodando";
    }
}
