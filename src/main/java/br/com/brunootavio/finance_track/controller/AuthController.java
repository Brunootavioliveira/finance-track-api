package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.LoginRequestDTO;
import br.com.brunootavio.finance_track.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController { //cria endpoint

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequestDTO requestDTO) {
        return authService.login(requestDTO);
    }
}
