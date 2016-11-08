package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.apss.fazendaweb.model.Usuario;
import br.com.apss.fazendaweb.model.filter.UsuarioFilter;
import br.com.apss.fazendaweb.repository.UsuarioRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.porNome(usuario.getNome());

		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Já existe um Usuário com esse Login informado.");
		}
		if (usuario.getId() == null) {
			usuario.setCadastro(new Date());
		}
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public void remover(Usuario usuario) {
		usuarioRepository.remove(usuario);
	}

	public Usuario porNome(String nome) {
		return usuarioRepository.porNome(nome);
	}

	public Usuario porNome(String nome, String senha) {
		return usuarioRepository.porNomeSenha(nome, senha);
	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.listarTodos();
	}

	public List<Usuario> filtrados(UsuarioFilter filtro) {
		return usuarioRepository.filtrados(filtro);

	}

	public Usuario porId(Long id) {
		return usuarioRepository.porId(id);
	}

}
