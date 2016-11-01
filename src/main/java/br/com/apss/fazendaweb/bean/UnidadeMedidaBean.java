package br.com.apss.fazendaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.apss.fazendaweb.enums.AtivoInativo;
import br.com.apss.fazendaweb.model.UnidadeMedida;
import br.com.apss.fazendaweb.service.UnidadeMedidaService;
import br.com.apss.fazendaweb.util.FacesUtil;

@Named
@ViewScoped
public class UnidadeMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UnidadeMedida unidadeMedida;
	private List<UnidadeMedida> unidadeMedidas = new ArrayList<>();
	private UnidadeMedida unidadeMedidaSelecionado;
	private Long id;

	@Inject
	UnidadeMedidaService unidadeMedidaService;

	/****************************** Metodos *************************/

	public void inicializarBean() {
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()) {
			listarTodos();
		}
	}

	public UnidadeMedidaBean() {
		this.unidadeMedida = new UnidadeMedida();
		this.unidadeMedida.setStatus(true);
	}

	public void listarTodos() {
		unidadeMedidas = unidadeMedidaService.listarTodos();
	}

	public List<AtivoInativo> getAtivoInativo() {
		return Arrays.asList(AtivoInativo.values());
	}

	public void novoCadastro() {
		this.unidadeMedida = new UnidadeMedida();
		this.unidadeMedida.setStatus(true);
	}

	public void salvar() {
		unidadeMedidaService.salvar(this.unidadeMedida);
		this.unidadeMedidaSelecionado = null;
		novoCadastro();
		Messages.addGlobalInfo("Registro salvo com sucesso");
	}

	public void prepararExclusao(Long id) {
		this.unidadeMedida = unidadeMedidaService.porId(id);
	}

	public void excluir() {
		unidadeMedidaService.remover(this.unidadeMedida);
		this.unidadeMedidaSelecionado = null;
		listarTodos();
		Messages.addGlobalInfo("Registro excluido com sucesso");
	}

	public void carregarEdicao() {
		if (id != null) {
			this.unidadeMedida = unidadeMedidaService.buscarPorId(id);
		}

	}

	/****************************** Getters e Setters *************************/

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public void setUnidadeMedidas(List<UnidadeMedida> unidadeMedidas) {
		this.unidadeMedidas = unidadeMedidas;
	}

	public UnidadeMedida getUnidadeMedidaSelecionado() {
		return unidadeMedidaSelecionado;
	}

	public void setUnidadeMedidaSelecionado(UnidadeMedida unidadeMedidaSelecionado) {
		this.unidadeMedidaSelecionado = unidadeMedidaSelecionado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/****************************** Getters e Setters *************************/
}
