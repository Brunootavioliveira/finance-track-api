package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    public final UserRepository userRepository;  //para ele mexer no estoque(banco de dados)
    // Eu (userService) vou ter um ajudante chamado user Repository
    // final: depois que escolher o ajudante,não pode trocar ele
    public final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //injeção de dependencia: trouxe um ajudante pronto para o serviço


    public User save(User user) { //id, name, email,senha...
        // Criptografa antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user); //guarda isso pra mim no estoque, atributos do user
    }
}
