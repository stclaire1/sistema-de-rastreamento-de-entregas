package br.edu.iftm.rastreamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Rastreamento> getAllRastreamentos() {
        Iterable<Rastreamento> rastreamentosIterable = rastreamentoRepository.findAll();
        List<Rastreamento> rastreamentosList = new ArrayList<>();
        rastreamentosIterable.forEach(rastreamentosList::add);
        return rastreamentosList;
    }

    public Rastreamento getRastreamentoById(Long id) {
        return rastreamentoRepository.findById(id).get();
    }

}
