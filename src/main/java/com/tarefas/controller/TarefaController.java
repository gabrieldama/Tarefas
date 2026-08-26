package com.tarefas.controller;

import com.tarefas.dto.TarefaRequest;
import com.tarefas.model.Tarefa;
import com.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa criar(@RequestBody TarefaRequest body){
        return tarefaService.agendar(body.usuarioId(), body.categoriaId());
    }

    @GetMapping("/listar")
    public List<Tarefa> listar(){
        return tarefaService.listar();
    }

    @GetMapping("/listar/{id}")
    public Tarefa buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }
    @PutMapping
    public Tarefa atualizar(@PathVariable Long id, @Valid @RequestBody TarefaRequest novo){
        return tarefaService.atualizar(id, novo);
    }
    @DeleteMapping("Excluir/{id}")
    public void excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
    }
}
