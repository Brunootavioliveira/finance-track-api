package br.com.brunootavio.finance_track.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "income")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Income { //receita

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) //campo obrigatorio, criando como not null
    private User user;
}
