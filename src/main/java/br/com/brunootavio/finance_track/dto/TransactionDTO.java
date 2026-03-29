package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(String description,
                             BigDecimal amount,
                             String type,
                             LocalDateTime dateTime) {
}
