package com.tarefas.controller;


import com.tarefas.model.Categoria;
import com.tarefas.model.Usuario;
import com.tarefas.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@Tag(name = "Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/Listar")
    public List<Categoria> listar(){
        return categoriaService.listar();
    }

    @PostMapping("/Cadastrar")
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria);
    }

    @GetMapping("/Listar/{id}")
    public Categoria buscarPorId(Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/Atualizar/{id}")
    public Categoria atualizar(@RequestBody Categoria categoria){
        return categoriaService.atualizar(categoria);
    }

    @DeleteMapping("Excluir/{id}")
    public void excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
    }
}
