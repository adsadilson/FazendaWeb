package br.com.apss.fazendaweb.enums;

public enum EstadoCivil {

	CASADO("CASADO(a)"),
	SOLTEIRO("SOLTEIRO(a)"),
	DIVORCIADO("DIVORCIADO(a)"),
	VIUVO("VIÚVO(a)"),
	OUTROS("OUTROS");
	
	private String descricao;

	EstadoCivil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}