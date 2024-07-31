package com.treinando.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinando.banco.entity.Conta;
import com.treinando.banco.repository.ContaRepository;

@RestController
@RequestMapping("/api/conta")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	   @PostMapping("/criar")
	    public Conta criarConta(@RequestBody Conta conta) {
	        return contaRepository.save(conta);
	    }
	   @GetMapping("/{id}")
	   public ResponseEntity<Conta> obterConta(@PathVariable Long id) {
	       return contaRepository.findById(id)
	               .map(conta -> ResponseEntity.ok().body(conta))
	               .orElse(ResponseEntity.notFound().build());
	   
	    }

}
