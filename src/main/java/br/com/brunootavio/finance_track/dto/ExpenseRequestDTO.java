package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseRequestDTO(
        String description,
        BigDecimal amount,
        Long categoryId) {
}
