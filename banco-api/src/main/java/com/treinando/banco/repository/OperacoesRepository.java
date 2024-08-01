package com.treinando.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.treinando.banco.entity.Operacoes;

@Repository
public interface OperacoesRepository extends JpaRepository<Operacoes, Long> {
}
