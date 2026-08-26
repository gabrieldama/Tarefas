package com.tarefas.service;


import com.tarefas.exception.EmailJaCadastradoException;
import com.tarefas.exception.RecursoNaoEncontradoException;
import com.tarefas.model.Categoria;
import com.tarefas.model.Usuario;
import com.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return  usuarioRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Usuario com id: " + id + " não encontrado"));
    }

    public Usuario save(Usuario usuario){
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new EmailJaCadastradoException("Email: " + usuario.getEmail() + " já registrado");
        }

        return usuarioRepository.save(usuario);

    }
}
