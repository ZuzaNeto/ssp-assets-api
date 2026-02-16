package com.example.demo.controllers;

import com.example.demo.entities.Departamento;
import com.example.demo.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll() {
        List<Departamento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Departamento> insert(@RequestBody Departamento obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}