package br.com.apss.fazendaweb.enums;

public enum TipoProduto {

	REV("REVENDA"),
	CON("CONSUMO"),
	SER("SERVICO");
	
	private String descricao;

	TipoProduto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}