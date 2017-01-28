package br.com.apss.fazendaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.com.apss.fazendaweb.model.Animal;
import br.com.apss.fazendaweb.model.CondicaoCorporal;
import br.com.apss.fazendaweb.model.FichaAnimal;
import br.com.apss.fazendaweb.model.Pessoa;
import br.com.apss.fazendaweb.service.AnimalService;
import br.com.apss.fazendaweb.service.CondicaoCorporalService;
import br.com.apss.fazendaweb.service.FichaAnimalService;
import br.com.apss.fazendaweb.service.PessoaService;
import br.com.apss.fazendaweb.util.FacesUtil;

@Named
@ViewScoped
public class FichaPartoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private FichaAnimal parto;
	private List<FichaAnimal> partos = new ArrayList<>();
	private FichaAnimal partoSelecionado;
	private Boolean edicao = false;

	@Inject
	FichaAnimalService partoService;

	@Inject
	AnimalService animalService;

	@Inject
	PessoaService profissionalService;

	@Inject
	CondicaoCorporalService condicaoCorporalService;

	/****************************** Metodos *************************/

	public void inicializarBean() {
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()) {
			carregarTabela();
		}

	}

	private void carregarTabela() {
		parto = new FichaAnimal();
		partos = partoService.porTipoLanc("COBERTURA/DIAGNOSTICO");
	}

	public List<Animal> getAnimals() {
		return animalService.buscarPraParto();
		// TODO Falta termina essa classe
	}

	public boolean verificarParto() {
		//return partoService.verificaParto(this.parto.getAnimal(), this.edicao, this.parto);
		return false;
	}

	public List<Animal> getReprodutores() {
		return animalService.buscarAnimalReprodutor();
	}

	public List<CondicaoCorporal> getCondicoesCorporal() {
		return condicaoCorporalService.listarTodos(true);
	}

	public List<Pessoa> getResponsaveis() {
		return profissionalService.listarProfissional(true);
	}

	public void novoCadastro() {
		parto = new FichaAnimal();
	}

	public void salvar() {
		if (!verificarParto()) {
			this.parto.setDtLanc(new Date());
			this.parto.setTipoLanc("COBERTURA/DIAGNOSTICO");
			partoService.salvar(this.parto);
			this.partoSelecionado = null;
			carregarTabela();
			Messages.addGlobalInfo("Registro salvo com sucesso");
			RequestContext request = RequestContext.getCurrentInstance();
			request.addCallbackParam("sucesso", true);
			this.setEdicao(false);
		}
	}

	public void excluir() {
		partoService.remover(this.parto);
		this.partoSelecionado = null;
		carregarTabela();
		Messages.addGlobalInfo("Registro excluido com sucesso");
	}

	public void editar() {
		this.parto = partoService.buscarPorId(partoSelecionado.getId());
		this.setEdicao(true);
	}

	public FichaAnimal getParto() {
		return parto;
	}

	public void setParto(FichaAnimal parto) {
		this.parto = parto;
	}

	public List<FichaAnimal> getPartos() {
		return partos;
	}

	public void setPartos(List<FichaAnimal> partos) {
		this.partos = partos;
	}

	public FichaAnimal getPartoSelecionado() {
		return partoSelecionado;
	}

	public void setPartoSelecionado(FichaAnimal partoSelecionado) {
		this.partoSelecionado = partoSelecionado;
	}

	public Boolean getEdicao() {
		return edicao;
	}

	public void setEdicao(Boolean edicao) {
		this.edicao = edicao;
	}

	/****************************** Getters e Setters *************************/

}
