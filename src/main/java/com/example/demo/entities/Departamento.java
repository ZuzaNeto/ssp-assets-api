package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Ex: Delegacia de Homicídios
    private String sigla; // Ex: DH

    @JsonIgnore // Evita que o JSON entre em loop infinito ao listar
    @OneToMany(mappedBy = "departamento")
    private List<Ativo> ativos = new ArrayList<>();
}