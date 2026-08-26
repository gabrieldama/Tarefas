package com.tarefas.service;


import com.tarefas.dto.TarefaRequest;
import com.tarefas.exception.RecursoNaoEncontradoException;
import com.tarefas.model.Categoria;
import com.tarefas.model.Tarefa;
import com.tarefas.model.Usuario;
import com.tarefas.repository.CategoriaRepository;
import com.tarefas.repository.TarefaRepository;
import com.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private TarefaRepository tarefaRepository;


    public Tarefa toTarefa(TarefaRequest novo, Categoria categoria, Usuario usuario) {
        return new Tarefa(
                novo.id(),
                novo.titulo(),
                novo.descricao(),
                novo.concluido(),
                novo.prazo(),
                usuario,
                categoria

        );
    }

    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    public Tarefa criar(Long usuarioId, Long categoriaId){

        Usuario usuarioQueVeioDoBanco = usuarioService.buscarPorId(usuarioId);
        Categoria categoriaQueVeioDoBanco = categoriaService.buscarPorId(categoriaId);

        Tarefa tarefa = new Tarefa();
        tarefa.setUsuario(usuarioQueVeioDoBanco);
        tarefa.setCategoria(categoriaQueVeioDoBanco);
        return tarefaRepository.save(tarefa);

    }

    public void excluir(Long id){
        Tarefa atual = buscarPorId(id);
        tarefaRepository.deleteById(id);
    }

    public Tarefa buscarPorId(Long id){
        return  tarefaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Tarefa com id: " + id + " não encontrada"));
    }

    public Tarefa atualizar(Long id, TarefaRequest tarefas){
        Tarefa atual = buscarPorId(id);
        Categoria categoriaQueVeioDoBanco = categoriaService.buscarPorId(tarefas.categoriaId());
        Usuario usuarioQueVeioDoBanco = usuarioService.buscarPorId(tarefas.usuarioId());

        return tarefaRepository.save(toTarefa(tarefas, categoriaQueVeioDoBanco, usuarioQueVeioDoBanco));
    }


}
