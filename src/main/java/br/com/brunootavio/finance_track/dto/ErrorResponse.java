package br.com.brunootavio.finance_track.dto;

import java.time.LocalDateTime;

public record ErrorResponse(int status,
                            String error,
                            String message,
                            LocalDateTime timestamp) {
}
