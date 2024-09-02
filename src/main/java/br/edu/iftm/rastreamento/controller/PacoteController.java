package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@Operation(summary = "Retorna todos os pacotes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de pacotes retornada com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Pacote.class)) }),
			@ApiResponse(responseCode = "204", description = "Nenhum pacote foi encontrado")
	})
	@GetMapping
	public List<Pacote> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@Operation(summary = "Cria um novo pacote")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Pacote criado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Pacote.class)) }),
			@ApiResponse(responseCode = "400", description = "Houve um erro na criação do pacote", content = @Content)
	})
	@PostMapping
	public Pacote createPacote(@RequestBody Pacote pacote) {
		return pacoteService.createPacote(pacote);
	}

	@Operation(summary = "Retorna um pacote pelo ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Pacote retornado com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Pacote.class))}),
		@ApiResponse(responseCode = "204", description = "Não foi encontrado nenhum pacote que corresponde ao ID informado", content = @Content)
	})
	@GetMapping("/{id}")
	public Pacote getPacoteById(@PathVariable Long id) {
		return pacoteService.getPacoteById(id);
	}

	@Operation(summary = "Atualiza um pacote existente pelo ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Pacote atualizado com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Pacote.class))}),
		@ApiResponse(responseCode = "204", description = "Não foi encontrado nenhum pacote que corresponde ao ID informado", content = @Content)
	})
	@PutMapping("/{id}")
	public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
		return pacoteService.updatePacote(id, pacoteDetails);
	}

	@Operation(summary = "Deleta um pacote existente pelo ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Pacote deletado com sucesso"),
		@ApiResponse(responseCode = "204", description = "Não foi encontrado nenhum pacote que corresponde ao ID informado")
	})
	@DeleteMapping("/{id}")
	public void deletePacote(@PathVariable Long id) {
		pacoteService.deletePacote(id);
	}
}