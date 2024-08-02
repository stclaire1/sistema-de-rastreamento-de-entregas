package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public List<Endereco> getAllEnderecos() {
		return enderecoService.getAllEnderecos();
	}

	@PostMapping
	public Endereco createEndereco(@RequestBody Endereco endereco) {
		return enderecoService.createEndereco(endereco);
	}
}
