package br.com.brunootavio.finance_track.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity //tabela no banco
@Data
@NoArgsConstructor //cria contructor vazio
@AllArgsConstructor
@Builder
public class Expense { //despesas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount; //valor
    private LocalDate date;

    @ManyToOne //muitas despesas pertencem a um usuario
    @JoinColumn(name = "user_id") //esse despesa pertence ao usuario de numero 1
    //cria uma coluna user_id, para guardar o numero do usuario dona da despesa
    private User user; //essa despesa pertence a um objeto user
}
