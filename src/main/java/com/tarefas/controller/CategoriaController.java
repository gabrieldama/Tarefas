package com.tarefas.controller;


import com.tarefas.model.Categoria;
import com.tarefas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaService.listar();
    }
    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria);
    }
    @PutMapping
    public Categoria atualizar(@RequestBody Categoria categoria){
        return categoriaService.atualizar(categoria);
    }

    @DeleteMapping("Excluir/{id}")
    public void excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
    }
}
