package br.com.brunootavio.finance_track.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //é uma anotação do Spring Boot que diz: "Essa classe vai receber requisições HTTP e devolver respostas em formato JSON (normalmente)."
public class HealthController {


    @GetMapping("/")
    public String health() {
        return "API running";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
