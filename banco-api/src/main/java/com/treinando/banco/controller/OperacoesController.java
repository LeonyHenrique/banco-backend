package com.treinando.banco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinando.banco.entity.Conta;
import com.treinando.banco.repository.ContaRepository;
import com.treinando.banco.repository.OperacoesRepository;

@RestController
@RequestMapping("/api")
public class OperacoesController {
	
	 @Autowired
	    private OperacoesRepository operacoesRepository;
	 
		@Autowired
		private ContaRepository contaRepository;
	
		@GetMapping("/saldo")
		public ResponseEntity<String> getSaldo(@RequestParam Long id) {
			return ResponseEntity.ok(String.valueOf(contaRepository.findById(id).get().getSaldo()) ); 
				
		}

		@PostMapping("/depositar")
		public ResponseEntity<String> depositar(@RequestParam Long id, @RequestParam Double valor) {
		    System.out.println("Recebendo requisição para depositar. ID: " + id + ", Valor: " + valor);
		   Optional<Conta> conta = contaRepository.findById(id);
		   if(!conta.isPresent())return ResponseEntity.notFound().build();
		   conta.get().setSaldo(conta.get().getSaldo() + valor );
		  contaRepository.save(conta.get());
		     return ResponseEntity.ok("conta");
		    
		}

		@PostMapping("/sacar")
		public ResponseEntity<String> sacar(@RequestParam Long id, @RequestParam Double valor) {
			 Optional<Conta> conta = contaRepository.findById(id);
			   conta.get().setSaldo(conta.get().getSaldo() - valor );
				  contaRepository.save(conta.get());
			return ResponseEntity.ok(String.valueOf(conta.get().getSaldo())); 
		
}
}

