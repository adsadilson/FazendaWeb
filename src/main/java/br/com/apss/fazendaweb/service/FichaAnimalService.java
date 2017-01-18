package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.apss.fazendaweb.model.FichaAnimal;
import br.com.apss.fazendaweb.repository.FichaAnimalRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class FichaAnimalService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FichaAnimalRepository fichaAnimalRepository;

	@Transactional
	public FichaAnimal salvar(FichaAnimal fichaAnimal) {
		/*FichaAnimal fichaAnimalExistente = fichaAnimalRepository.porNome(fichaAnimal.getNome());

		if (fichaAnimalExistente != null && !fichaAnimalExistente.equals(fichaAnimal)) {
			throw new NegocioException("Já existe uma Grupo de Usuário com esse nome informado.");
		}*/
		return fichaAnimalRepository.save(fichaAnimal);
	}

	@Transactional
	public void remover(FichaAnimal fichaAnimal) {
		fichaAnimalRepository.remove(fichaAnimal);
	}

	public FichaAnimal buscarPorId(Long id) {
		return fichaAnimalRepository.porId(id);
	}

	public List<FichaAnimal> listarTodos() {
		return fichaAnimalRepository.listarTodos();
	}

	public List<FichaAnimal> grupoCondicao(FichaAnimal op) {
		return fichaAnimalRepository.grupoCondicao(op);
		
	}

	public FichaAnimal porId(Long id) {
		return fichaAnimalRepository.porId(id);
	}

}
