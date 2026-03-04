package br.com.brunootavio.finance_track.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.List;

@Entity //A classe vira uma tabela no banco
@Table(name = "users") //Definir nome da tabela
@Data
@NoArgsConstructor //Cria contrutor vazio
@AllArgsConstructor
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

    @OneToMany(mappedBy = "user") //um usuario para varias dispesas. mappedny: quem manda na relacao é o campo user
    @JsonIgnore
    private List<Expense> expenses;
}
