package com.treinando.banco.entity;

import jakarta.persistence.Entity;

@Entity
public class Operacoes {
    Double saldo;
    String conta;
    
    public Operacoes(String conta) {
        saldo = 0.0;
        this.conta = conta;
    }
    
    public void depositar(Double deposito) {
        if (deposito <= 0) {
            System.out.println("Erro");
        } else {
            saldo += deposito;
        }
    }
    
    public void sacar(Double sacar) {
        if (sacar > saldo) {
            System.out.println("saldo insuficiente");
        } else {
            saldo -= sacar;
        }
    }
    
    @Override
    public String toString() {
        return  + saldo + "";
    }
}