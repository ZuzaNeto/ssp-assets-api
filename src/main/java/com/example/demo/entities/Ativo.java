package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_ativos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String patrimonio; // Ex: SSP-2026-001

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo; // Ex: Rádio, Notebook, Câmera

    private String descricao;

    @Column(nullable = false)
    private String status; // Ex: ATIVO, MANUTENCAO, BAIXADO

    private LocalDateTime dataCadastro;

    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}