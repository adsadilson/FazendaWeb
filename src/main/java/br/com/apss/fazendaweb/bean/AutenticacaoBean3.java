package br.com.apss.fazendaweb.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.apss.fazendaweb.model.Usuario;
import br.com.apss.fazendaweb.service.UsuarioService;

@Named
@SessionScoped
public class AutenticacaoBean3 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Usuario usuarioLogado;

	@Inject
	UsuarioService usuarioDAO;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {

			usuarioLogado = usuarioDAO.autenticar(usuario.getNome(), usuario.getSenha());

			if (usuarioLogado == null) {
				Messages.addGlobalError("CPF e/ou senha incorretos");
				return;
			}

			Faces.redirect("./home.jsf");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}


}
