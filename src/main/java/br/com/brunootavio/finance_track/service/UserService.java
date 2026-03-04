package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.User;
import br.com.brunootavio.finance_track.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    public final UserRepository userRepository;  //para ele mexer no estoque(banco de dados)
    // Eu (userService) vou ter um ajudante chamado user Repository
    // final: depois que escolher o ajudante,não pode trocar ele

    public UserService(UserRepository userRepository) { //"Spring fala: Oi service, toma aqui seu ajudante" - "Obg, vou guardar ele aqui"
        this.userRepository = userRepository;
    }
    //injeção de dependencia: trouxe um ajudante pronto para o serviço


    public User save(@RequestBody User user) { //id, name, email,senha...
        return userRepository.save(user); //guarda isso pra mim no estoque, atributos do user
    }
}
