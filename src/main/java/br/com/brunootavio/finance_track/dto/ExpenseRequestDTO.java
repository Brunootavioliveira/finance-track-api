package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;

public record ExpenseRequestDTO(
        String description,
        BigDecimal amount,
        Long categoryId) {
}
