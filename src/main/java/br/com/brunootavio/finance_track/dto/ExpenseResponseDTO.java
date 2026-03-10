package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime date
) {
}
