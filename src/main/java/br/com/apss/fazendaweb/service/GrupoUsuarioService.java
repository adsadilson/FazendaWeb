package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.apss.fazendaweb.model.GrupoUsuario;
import br.com.apss.fazendaweb.model.filter.GrupoUsuarioFilter;
import br.com.apss.fazendaweb.repository.GrupoUsuarioRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class GrupoUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoUsuarioRepository grupoUsuarioRepository;

	@Transactional
	public GrupoUsuario salvar(GrupoUsuario grupoUsuario) {
		GrupoUsuario grupoUsuarioExistente = grupoUsuarioRepository.porNome(grupoUsuario.getDescricao());

		if (grupoUsuarioExistente != null && !grupoUsuarioExistente.equals(grupoUsuario)) {
			throw new NegocioException("Já existe uma grupoUsuario com esse nome informado.");
		}
		return grupoUsuarioRepository.save(grupoUsuario);
	}

	@Transactional
	public void remover(GrupoUsuario grupoUsuario) {
		grupoUsuarioRepository.remove(grupoUsuario);
	}

	public GrupoUsuario buscarPorId(Long id) {
		return grupoUsuarioRepository.porId(id);
	}

	public List<GrupoUsuario> listarTodos() {
		return grupoUsuarioRepository.listarTodos();
	}

	public List<GrupoUsuario> filtrados(GrupoUsuarioFilter filtro) {
		return grupoUsuarioRepository.filtrados(filtro);

	}

	public GrupoUsuario porId(Long id) {
			System.out.println("servico "+id);
		return grupoUsuarioRepository.porId(id);
	}

}
