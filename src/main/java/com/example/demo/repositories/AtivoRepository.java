package com.example.demo.repositories;

import com.example.demo.entities.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

    // O Spring gera o SQL: SELECT * FROM tb_ativos WHERE departamento_id = ?
    List<Ativo> findByDepartamentoId(Long departamentoId);
}