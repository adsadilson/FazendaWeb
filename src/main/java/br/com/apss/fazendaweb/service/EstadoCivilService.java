package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.apss.fazendaweb.model.EstadoCivil;
import br.com.apss.fazendaweb.repository.EstadoCivilRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class EstadoCivilService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoCivilRepository estadoCivilRepository;

	@Transactional
	public EstadoCivil salvar(EstadoCivil estadoCivil) {
		EstadoCivil estadoCivilExistente = estadoCivilRepository.porNome(estadoCivil.getNome());

		if (estadoCivilExistente != null && !estadoCivilExistente.equals(estadoCivil)) {
			throw new NegocioException("Já existe uma Estado Civil com esse nome informado.");
		}
		return estadoCivilRepository.save(estadoCivil);
	}

	@Transactional
	public void remover(EstadoCivil estadoCivil) {
		estadoCivilRepository.remove(estadoCivil);
	}

	public EstadoCivil buscarPorId(Long id) {
		return estadoCivilRepository.porId(id);
	}

	public List<EstadoCivil> listarTodos() {
		return estadoCivilRepository.listarTodos();
	}

	public List<EstadoCivil> grupoCondicao(EstadoCivil op) {
		return estadoCivilRepository.grupoCondicao(op);
		
	}

	public EstadoCivil porId(Long id) {
		return estadoCivilRepository.porId(id);
	}

}
