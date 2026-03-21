package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record IncomeRequestDTO(
        String description,
        BigDecimal amount,
        LocalDateTime dateTime) {
}
