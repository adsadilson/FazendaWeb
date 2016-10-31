package br.com.apss.fazendaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.omnifaces.util.Messages;

import br.com.apss.fazendaweb.enums.AtivoInativo;
import br.com.apss.fazendaweb.model.GrupoUsuario;
import br.com.apss.fazendaweb.model.filter.GrupoUsuarioFilter;
import br.com.apss.fazendaweb.service.GrupoUsuarioService;
import br.com.apss.fazendaweb.util.FacesUtil;

@Named
@ViewScoped
public class GrupoUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private GrupoUsuario grupoUsuario;
	private List<GrupoUsuario> grupoUsuarios = new ArrayList<>();
	private GrupoUsuario grupoUsuarioSelecionado;
	private GrupoUsuarioFilter filtro;

	@Inject
	GrupoUsuarioService grupoUsuarioService;

	/****************************** Metodos *************************/

	public void inicializarBean() {
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()) {
			listarTodos();
		}
	}

	public GrupoUsuarioBean() {
		filtro = new GrupoUsuarioFilter();
		this.grupoUsuario = new GrupoUsuario();
		this.grupoUsuario.setAtivo(true);
	}

	public void listarTodos() {
		grupoUsuarios = grupoUsuarioService.listarTodos();
	}

	public void pesquisar() {
		grupoUsuarios = grupoUsuarioService.filtrados(filtro);
	}

	public List<AtivoInativo> getAtivoInativo() {
		return Arrays.asList(AtivoInativo.values());
	}

	public void novoFiltro() {
		filtro = new GrupoUsuarioFilter();
	}

	public void novoCadastro() {
		this.grupoUsuario = new GrupoUsuario();
		this.grupoUsuario.setAtivo(true);
	}

	public void salvar() {
		grupoUsuarioService.salvar(this.grupoUsuario);
		this.grupoUsuarioSelecionado = null;
		novoCadastro();
		Messages.addGlobalInfo("Registro salvo com sucesso");
	}

	public void prepararExclusao(Long id) {
		this.grupoUsuario = grupoUsuarioService.porId(id);
	}

	public void excluir() {
		grupoUsuarioService.remover(this.grupoUsuario);
		this.grupoUsuarioSelecionado = null;
		listarTodos();
		Messages.addGlobalInfo("Registro excluido com sucesso");
	}

	public void editar() {
		String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("codigo");
		if (id != null) {
			this.grupoUsuario = grupoUsuarioService.buscarPorId(Long.parseLong(id));
		}

	}

	/****************************** Getters e Setters *************************/

	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}

	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}

	public List<GrupoUsuario> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	public void setGrupoUsuarios(List<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	public GrupoUsuario getGrupoUsuarioSelecionado() {
		return grupoUsuarioSelecionado;
	}

	public void setGrupoUsuarioSelecionado(GrupoUsuario grupoUsuarioSelecionado) {
		this.grupoUsuarioSelecionado = grupoUsuarioSelecionado;
	}

	public GrupoUsuarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(GrupoUsuarioFilter filtro) {
		this.filtro = filtro;
	}

	/****************************** Getters e Setters *************************/
}
