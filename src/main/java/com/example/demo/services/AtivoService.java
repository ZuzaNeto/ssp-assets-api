package com.example.demo.services;

import com.example.demo.entities.Ativo;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository repository;

    public List<Ativo> listarTodos() {
        return repository.findAll();
    }

    public Ativo salvar(Ativo ativo) {
        // Aqui poderíamos colocar regras, como:
        // "validar se o patrimônio segue o padrão da SSP"
        return repository.save(ativo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Ativo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Ativo atualizar(Long id, Ativo obj) {
        try {
            Ativo entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Ativo entity, Ativo obj) {
        entity.setNome(obj.getNome());
        entity.setTipo(obj.getTipo());
        entity.setStatus(obj.getStatus());
        entity.setDescricao(obj.getDescricao());
    }

    public List<Ativo> buscarPorDepartamento(Long deptoId) {
        return repository.findByDepartamentoId(deptoId);
    }

}