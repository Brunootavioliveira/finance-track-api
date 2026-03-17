package br.com.brunootavio.finance_track.repository;

import br.com.brunootavio.finance_track.model.Category;
import br.com.brunootavio.finance_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUser(User user);

    Optional<Category> findByNameAndUser(String name, User user); //vier cheio, avisa "ja existe essa categoria"
    //vier vazio, deixa salvar
}
