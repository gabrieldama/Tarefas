package com.tarefas.controller;


import com.tarefas.model.Usuario;
import com.tarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listar();
    }
    @GetMapping("/{id}")
    public Usuario buscarPorId(Long id) {
        return usuarioService.buscarPorId(id);
    }
    @PostMapping
    public Usuario salvar(Usuario usuario) {
        return usuarioService.save(usuario);
    }
}
