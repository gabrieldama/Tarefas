package com.tarefas.service;

import com.tarefas.exception.RecursoNaoEncontradoException;
import com.tarefas.model.Categoria;
import com.tarefas.model.Usuario;
import com.tarefas.repository.CategoriaRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(Long id){
        return  categoriaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Categoria com id: " + id + " não encontrado"));
    }

    public Categoria atualizar(Categoria categoria){
        Categoria atual =  buscarPorId(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void excluir(Long id){
        Categoria atual =  buscarPorId(id);
        categoriaRepository.deleteById(id);
    }

}
