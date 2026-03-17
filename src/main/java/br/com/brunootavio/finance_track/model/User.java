package br.com.brunootavio.finance_track.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity //A classe vira uma tabela no banco
@Table(name = "users") //Definir nome da tabela
@Data
@NoArgsConstructor //Cria contrutor vazio
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank //Não deixa salvar vazio
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //um usuario para varias dispesas. mappedny: quem manda na relacao é o campo user
    private List<Expense> expenses;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Income> incomes;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Category> categories;

}
