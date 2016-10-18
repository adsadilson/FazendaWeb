package br.com.apss.fazendaweb.enums;

public enum UnidadeMedida {

	KG("KG - KILOGRAMA"),
	UN("UN - UNIDADE"),
	PC("PC - PACOTE"),
	CX("CX - CAIXA");
	
	private String descricao;

	UnidadeMedida(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}