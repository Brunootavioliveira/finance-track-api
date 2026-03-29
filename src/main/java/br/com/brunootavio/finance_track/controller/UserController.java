package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.UserRequestDTO;
import br.com.brunootavio.finance_track.dto.UserResponseDTO;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //receber http e retornar json
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    // Eu (userController) vou ter um ajudante chamado contratado pelo service

    @PostMapping //Definir endpoint do tipo post(criar dados)
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO salvar(@RequestBody UserRequestDTO dto) { //service nao sabe nada sobre http, json, endpoint, por isso repete
        //separação de responsabilidade. Converte o json em UserRequestDTO
        User user = User.builder() //DTO → Entity | Controller trabalha com DTO - Banco trabalha com Entity
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .build();

        User saved = userService.save(user); //Service, salva isso pra mim.

        return new UserResponseDTO( //Entity → DTO de resposta
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }
}
