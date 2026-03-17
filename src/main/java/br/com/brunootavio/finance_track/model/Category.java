package br.com.brunootavio.finance_track.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) //tudo que fizer em user, replique para income e expense
    private List<Expense> expenses;
    //apagar o usar apaga TUDO (ALL)
}
