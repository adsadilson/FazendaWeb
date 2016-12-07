package br.com.apss.fazendaweb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.apss.fazendaweb.model.Produto;
import br.com.apss.fazendaweb.repository.ProdutoRepository;
import br.com.apss.fazendaweb.util.NegocioException;
import br.com.apss.fazendaweb.util.Transactional;

public class ProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;

	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtoRepository.porNome(produto.getNome());

		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Já existe uma Produto com esse nome informado.");
		}
		return produtoRepository.save(produto);
	}

	@Transactional
	public void remover(Produto produto) {
		produtoRepository.remove(produto);
	}

	public Produto buscarPorId(Long id) {
		return produtoRepository.porId(id);
	}

	public List<Produto> listarTodos() {
		return produtoRepository.listarTodos();
	}
	
	public List<Produto> grupoCondicao(Produto op) {
		return produtoRepository.grupoCondicao(op);
		
	}

	public Produto porId(Long id) {
		return produtoRepository.porId(id);
	}

}
