package br.com.brunootavio.finance_track.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")//valor
    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne //muitas despesas pertencem a um usuario
    @JoinColumn(name = "user_id") //esse despesa pertence ao usuario de numero 1
    //cria uma coluna user_id, para guardar o numero do usuario dona da despesa
    private User user; //essa despesa pertence a um objeto user

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
