package br.edu.iftm.rastreamento.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "rastreamentos")
@Entity
public class Pacote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idUnico;
	private String destinatario;
	@ManyToOne
	private Endereco endereco;
	private String status;
	@OneToMany(mappedBy = "pacote")
	private List<Rastreamento> rastreamentos;

	public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
		this.status = novoStatus;
		Rastreamento rastreamento = new Rastreamento();
		rastreamento.setDataHora(dataHora);
		rastreamento.setLocalizacao(localizacao);
		rastreamento.setStatus(novoStatus);
		rastreamentos.add(rastreamento);
	}
}
