package com.treinando.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinando.banco.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>  {

}
