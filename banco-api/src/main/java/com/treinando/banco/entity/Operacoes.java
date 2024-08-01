package com.treinando.banco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "operacoes")
public class Operacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    Double saldo;
    String conta;
    
    public Operacoes() {
		// TODO Auto-generated constructor stub
    	
    	
	}
    
    public Operacoes(Long id, Double saldo, String conta) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.conta = conta;
	}

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
    
    public void sacar(Double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        } else {
            this.saldo -= valor;
        }
    }
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
    public String toString() {
		  return "Operacoes{" +
	                "id=" + id +
	                ", saldo=" + saldo +
	                ", conta='" + conta + '\'' +
	                '}';
    }
}