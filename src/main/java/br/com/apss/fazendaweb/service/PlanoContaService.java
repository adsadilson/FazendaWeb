package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.apss.fazendaweb.model.PlanoConta;
import br.com.apss.fazendaweb.model.filter.PlanoContaFilter;
import br.com.apss.fazendaweb.repository.PlanoContaRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class PlanoContaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PlanoContaRepository planoContaRepository;

	@Transactional
	public PlanoConta salvar(PlanoConta planoConta) {
		PlanoConta planoContaExistente = planoContaRepository.porNome(planoConta.getMascara());

		if (planoContaExistente != null && !planoContaExistente.equals(planoConta)) {
			FacesContext.getCurrentInstance().validationFailed();
			throw new NegocioException("Já existe uma Plano de Conta com essa Mascara informado.");
		}
		return planoContaRepository.save(planoConta);
	}

	@Transactional
	public void remover(PlanoConta planoConta) {
		planoContaRepository.remove(planoConta);
	}

	public PlanoConta buscarPorId(Long id) {
		return planoContaRepository.porId(id);
	}

	public List<PlanoConta> listarTodos() {
		return planoContaRepository.listarTodos();
	}

	public List<PlanoConta> grupoCondicao(PlanoConta op) {
		return planoContaRepository.grupoCondicao(op);
		
	}

	public PlanoConta porId(Long id) {
		return planoContaRepository.porId(id);
	}

	public List<PlanoConta> filtrados(PlanoContaFilter filtro) {
		return planoContaRepository.filtrados(filtro);
	}

}
