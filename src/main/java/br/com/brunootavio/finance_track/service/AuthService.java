package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.dto.LoginRequestDTO;
import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String login(LoginRequestDTO requestDTO) {// da seus documentos e ganha um cartao de acesso -> jwtfilter
        User user = userRepository.findByEmail(requestDTO.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean senhaValida = passwordEncoder.matches(
                requestDTO.password(), //senha digitada
                user.getPassword() //senha do banco
                //compara
        );

        if (!senhaValida) {
            throw new RuntimeException("Senha incorreta");
        }
        return jwtService.generateToken(user); //gera JWT caso valide

    }
}
