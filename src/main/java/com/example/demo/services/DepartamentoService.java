package com.example.demo.services;

import com.example.demo.entities.Departamento;
import com.example.demo.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public List<Departamento> findAll() {
        return repository.findAll();
    }

    public Departamento insert(Departamento obj) {
        return repository.save(obj);
    }
}