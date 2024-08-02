package br.edu.iftm.rastreamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Endereco> getAllEnderecos() {
		Iterable<Endereco> enderecosIterable = enderecoRepository.findAll();
		List<Endereco> enderecosList = new ArrayList<>();
		enderecosIterable.forEach(enderecosList::add);
		return enderecosList;
	}

	public Optional<Endereco> getEnderecoById(Long id) {
		return enderecoRepository.findById(id);
	}

	public Endereco createEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco updateEndereco(Long id, Endereco enderecoDetails) {
		Endereco endereco = enderecoRepository.findById(id).get();
		endereco.setRua(enderecoDetails.getRua());
		endereco.setCidade(enderecoDetails.getCidade());
		endereco.setEstado(enderecoDetails.getEstado());
		endereco.setCep(enderecoDetails.getCep());
		return enderecoRepository.save(endereco);
	}

	public void deleteEndereco(Long id) {
		Endereco endereco = enderecoRepository.findById(id).get();
		enderecoRepository.delete(endereco);
	}
}
