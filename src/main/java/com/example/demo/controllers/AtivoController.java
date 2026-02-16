package com.example.demo.controllers;

import com.example.demo.entities.Ativo;
import com.example.demo.services.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ativos")
public class AtivoController {

    @Autowired
    private AtivoService service;

    // URL final: http://localhost:8080/ativos/buscar-por-departamento?deptoId=1
    @GetMapping(value = "/buscar-por-departamento")
    public ResponseEntity<List<Ativo>> findByDepartamento(@RequestParam Long deptoId) {
        List<Ativo> list = service.buscarPorDepartamento(deptoId);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Ativo> insert(@RequestBody Ativo obj) {
        obj = service.salvar(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Ativo> update(@PathVariable Long id, @RequestBody Ativo obj) {
        obj = service.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}