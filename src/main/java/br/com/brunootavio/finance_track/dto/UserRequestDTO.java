package br.com.brunootavio.finance_track.dto;

public record UserRequestDTO(
        String name,
        String email,
        String password
) {
}
