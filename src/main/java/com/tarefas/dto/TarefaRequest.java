package com.tarefas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TarefaRequest(
        Long id,
        String titulo,
        String descricao,
        Boolean concluido,
        LocalDateTime prazo,
        Long usuarioId,
        Long categoriaId
) {

}
