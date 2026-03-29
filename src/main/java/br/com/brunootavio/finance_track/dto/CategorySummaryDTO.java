package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;

public record CategorySummaryDTO(String categoryName,
                                 BigDecimal total) {
}
