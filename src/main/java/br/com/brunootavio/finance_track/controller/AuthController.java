package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.LoginRequestDTO;
import br.com.brunootavio.finance_track.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController { //cria endpoint

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO requestDTO) {
        return authService.login(requestDTO);
    }
}
