package br.com.apss.fazendaweb.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

import br.com.apss.fazendaweb.model.GrupoUsuario;
import br.com.apss.fazendaweb.model.Usuario;

@ManagedBean
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Usuario usuarioExclusao;
	private GrupoUsuario grupoSelecionado;
	private String confirmacaoSenha;

	/*@Autowired
	UsuarioService usuarioService;

	@Autowired
	ClassificacaoUsuarioService classificacaoUsuarioService;*/

	public void iniciarBean() {
		usuario = null;
		getListarTodos();
		getPopulaCombo();
	}

	public List<Usuario> getListarTodos() {
		return null;
		//return usuarioService.listarTodos();
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
				Messages.addGlobalError("Grupo já adcionado");
			} else {
				this.usuario.getGrupos().add(this.grupoSelecionado);
				this.grupoSelecionado = new GrupoUsuario();
			}
		} else {
			Messages.addGlobalError("Selecione um grupo antes de adicionar");
		}
	}

	public List<GrupoUsuario> getPopulaCombo() {
		return null;
	//	return classificacaoUsuarioService.listarTodos();
	}

	public void salvar() {
		/*if (this.usuario.getGrupos().size() > 0) {
			Usuario usuarioExistente = usuarioService.porNome(usuario.getNome());
			if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
				Messages.addGlobalError("Já existe um Usuário com esse nome informado");
			} else {
				usuarioService.save(usuario);
				getListarTodos();
				usuario = null;
				Messages.addGlobalInfo("Registro salvo com sucesso");
			}
		} else {
			Messages.addGlobalError("Escolhe pelo menos um grupo");
		}*/
	}

	public void closeExcluir() {
		this.grupoSelecionado = null;
	}

	public void editar(Long id) {
		/*this.usuario = usuarioService.obterPorId(id);
		this.confirmacaoSenha = this.usuario.getSenha();*/
	}

	public void prepararExclusao(Usuario usuario) {
		this.usuarioExclusao = usuario;
	}

	public void prepararExclusaoGrupo(GrupoUsuario grupo) {
		this.grupoSelecionado = grupo;
	}

	public void excluir() {
		/*try {
			usuarioService.remove(usuarioExclusao);
			Messages.addGlobalInfo("Registro excluir com sucesso");
			getListarTodos();
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				throw new NegocioException(
						"Não foi possível excluir esse registro, pois o mesmo possui vinculo com outras tabelas!");
			}
		}*/
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

	/* ###### Metodos Getters e Setters #####8 */
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

}
