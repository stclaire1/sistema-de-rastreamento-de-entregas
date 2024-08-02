package br.edu.iftm.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.RastreamentoService;

@RestController
@RequestMapping("/pacotes")
public class RastreamentoController {

	@Autowired
	private RastreamentoService rastreamentoService;

	@GetMapping("/{id}")
	public Rastreamento getPacoteById(@PathVariable Long id) {
		return rastreamentoService.getRastreamentoById(id);
	}

}