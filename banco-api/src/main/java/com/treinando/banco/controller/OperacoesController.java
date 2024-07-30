package com.treinando.banco.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinando.banco.entity.Operacoes;

@RestController
@RequestMapping("/api")
@CrossOrigin (origins = "http://localhost:5174")
public class OperacoesController {
	public Operacoes operacoes = new Operacoes("");
	
	@GetMapping("/saldo")
	public String getSaldo() {
		return operacoes.toString();
	}
	@PostMapping("/depositar")
	public String depositar (@RequestParam Double valor) {
		operacoes.depositar(valor);
		return operacoes.toString();
	}
	@PostMapping("/sacar")
	public String sacar (@RequestParam Double valor) {
		operacoes.sacar(valor);
		return operacoes.toString();
}
}

