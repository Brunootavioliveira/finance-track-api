package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record IncomeResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime dateTime) {
}
