package br.com.apss.fazendaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.apss.fazendaweb.model.GrupoUsuario;
import br.com.apss.fazendaweb.model.Usuario;
import br.com.apss.fazendaweb.service.GrupoUsuarioService;
import br.com.apss.fazendaweb.service.UsuarioService;
import br.com.apss.fazendaweb.util.FacesUtil;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Usuario usuarioExclusao;
	private List<Usuario> usuarios = new ArrayList<>();
	private List<GrupoUsuario> grupos = new ArrayList<>();
	private GrupoUsuario grupoSelecionado;
	private String confirmacaoSenha;

	@Inject
	UsuarioService usuarioService;

	@Inject
	GrupoUsuarioService grupoUsuarioService;

	public void inicializarBean() {
		if (FacesUtil.isNotPostback()) {
			grupos = grupoUsuarioService.listarTodos();
			for (GrupoUsuario grupoUsuario : grupos) {
				System.out.println("G R U P O :" + grupoUsuario.getNome());
			}
			System.out.println("Metodo inicializarBean");
		}
		usuarios = usuarioService.listarTodos();
	}

	public UsuarioBean() {
		System.out.println("Metodo Construtor");
		limpar();
	}

	private void limpar() {
		usuario = new Usuario();
		usuario.setAtivo(true);
	}

	public List<Usuario> listarTodos() {
		return usuarios = usuarioService.listarTodos();
	}

	public void novoUsuario() {
		usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setCadastro(new Date());
		this.confirmacaoSenha = null;

	}

	public void addGrupo() {
		if (this.grupoSelecionado != null) {
			if (this.usuario.getGrupos().contains(this.grupoSelecionado)) {
				// Messages.addGlobalError("Grupo j� adcionado");
			} else {
				this.usuario.getGrupos().add(this.grupoSelecionado);
				this.grupoSelecionado = new GrupoUsuario();
			}
		} else {
			// Messages.addGlobalError("Selecione um grupo antes de adicionar");
		}
	}

	public void salvar() {
		/*
		 * if (this.usuario.getGrupos().size() > 0) { Usuario usuarioExistente =
		 * usuarioService.porNome(usuario.getNome()); if (usuarioExistente !=
		 * null && !usuarioExistente.equals(usuario)) { Messages.
		 * addGlobalError("J� existe um Usu�rio com esse nome informado"); }
		 * else { usuarioService.save(usuario); getListarTodos(); usuario =
		 * null; Messages.addGlobalInfo("Registro salvo com sucesso"); } } else
		 * { Messages.addGlobalError("Escolhe pelo menos um grupo"); }
		 */
	}

	public void closeExcluir() {
		this.grupoSelecionado = null;
	}

	public void editar() {
		String codigo = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("codigo");
		if (codigo != null) {
			usuario = usuarioService.buscarPorId(Long.parseLong(codigo));
			this.confirmacaoSenha = usuario.getSenha();
		}

		/*
		 * this.usuario = usuarioService.obterPorId(id); this.confirmacaoSenha =
		 * 
		 */
	}

	public void prepararExclusao(Usuario usuario) {
		this.usuarioExclusao = usuario;
	}

	public void prepararExclusaoGrupo(GrupoUsuario grupo) {
		this.grupoSelecionado = grupo;
	}

	public void excluir() {
		/*
		 * try { usuarioService.remove(usuarioExclusao);
		 * Messages.addGlobalInfo("Registro excluir com sucesso");
		 * getListarTodos(); } catch (Exception e) { if (e instanceof
		 * DataIntegrityViolationException) { throw new NegocioException(
		 * "N�o foi poss�vel excluir esse registro, pois o mesmo possui vinculo com outras tabelas!"
		 * ); } }
		 */
	}

	public void removerGrupo() {
		int achou = -1;
		for (int i = 0; i < this.usuario.getGrupos().size(); i++) {
			if (this.usuario.getGrupos().get(i).getNome().equals(grupoSelecionado.getNome())) {
				achou = i;
			}
		}
		if (achou > -1) {
			this.usuario.getGrupos().remove(achou);
		}
	}

	public void voltar() {
		usuario = null;
	}

	/****************************** Getters e Setters *************************/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GrupoUsuario getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(GrupoUsuario grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public Usuario getUsuarioExclusao() {
		return usuarioExclusao;
	}

	public void setUsuarioExclusao(Usuario usuarioExclusao) {
		this.usuarioExclusao = usuarioExclusao;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<GrupoUsuario> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoUsuario> grupos) {
		this.grupos = grupos;
	}

	/****************************** Getters e Setters *************************/

}
