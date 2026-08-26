package com.tarefas.dto;

public record ErroResponse(
        int status,
        String mensagem
) {
}
