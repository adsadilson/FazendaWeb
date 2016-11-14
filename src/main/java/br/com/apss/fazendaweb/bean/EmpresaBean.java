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
import br.com.apss.fazendaweb.model.Pessoa;
import br.com.apss.fazendaweb.service.PessoaService;
import br.com.apss.fazendaweb.util.FacesUtil;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa empresa;
	private List<Pessoa> empresas = new ArrayList<>();
	private Pessoa empresaSelecionado;

	@Inject
	PessoaService empresaService;

	/****************************** Metodos *************************/

	public void inicializarBean() {
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()) {
			carregarTabela();
		}
	}

	private void carregarTabela() {
		empresas = empresaService.listarTodos();
	}

	public EmpresaBean() {
	}

	public List<AtivoInativo> getAtivoInativo() {
		return Arrays.asList(AtivoInativo.values());
	}

	public void novoCadastro() {
		this.empresa = new Pessoa();
		this.empresa.setStatus(true);
	}

	public void salvar() {
		empresaService.salvar(this.empresa);
		this.empresaSelecionado = null;
		carregarTabela();
		Messages.addGlobalInfo("Registro salvo com sucesso");
	}

	public void excluir() {
		empresaService.remover(this.empresa);
		this.empresaSelecionado = null;
		carregarTabela();
		Messages.addGlobalInfo("Registro excluido com sucesso");
	}

	public void editar() {
		this.empresa = empresaService.buscarPorId(empresaSelecionado.getId());
	}

	/****************************** Getters e Setters *************************/

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public List<Pessoa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Pessoa> empresas) {
		this.empresas = empresas;
	}

	public Pessoa getEmpresaSelecionado() {
		return empresaSelecionado;
	}

	public void setEmpresaSelecionado(Pessoa empresaSelecionado) {
		this.empresaSelecionado = empresaSelecionado;
	}
}

	/****************************** Getters e Setters *************************/

