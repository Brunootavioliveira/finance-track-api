package br.com.brunootavio.finance_track.dto;

import java.math.BigDecimal;
import java.util.List;

public record DashboardResponseDTO(BigDecimal balance,
                                   BigDecimal totalIncome,
                                   BigDecimal totalExpense,
                                   List<TransactionDTO> recentTransactions, List<CategorySummaryDTO> expensesByCategory) {
}
