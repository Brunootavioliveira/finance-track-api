package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //receber http e retornar json
@RequestMapping("/user")
@AllArgsConstructor
@Builder
public class UserController {

    private final UserService userService;
    // Eu (userController) vou ter um ajudante chamado contratado pelo service

    @PostMapping //Definir endpoint do tipo post(criar dados)
    public User salvar(@RequestBody User user) { //service nao sabe nada sobre http, json, endpoint, por isso repete
        return userService.save(user); //separação de responsabilidade
    }
}
