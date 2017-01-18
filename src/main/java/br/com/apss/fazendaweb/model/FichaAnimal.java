package br.com.apss.fazendaweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "ficha_animal")
@Entity
@SequenceGenerator(name = "FICHA_ANIMAL_ID", sequenceName = "FICHA_ANIMAL_SEQ", allocationSize = 1, initialValue = 1)
public class FichaAnimal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "FICHA_ANIMAL_ID")
	private Long id;

	@Column(length = 80)
	private String tipo;

	@Column(length = 80)
	private String descricao;

	@Column(length = 80)
	private String resultado;

	@Column(length = 200)
	private String obs;

	@Column(precision = 12, scale = 2)
	private BigDecimal quantidade = BigDecimal.ZERO;

	@Column(length = 80)
	private String unidade;

	@Column(length = 80)
	private String medicamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_lanc")
	private Date dtLanc;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vencto")
	private Date dtVencto;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_aux")
	private Date dtAux;

	@Column(length = 10)
	private String sexo;

	@Column(length = 80)
	private String condCorporal;

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public Date getDtLanc() {
		return dtLanc;
	}

	public void setDtLanc(Date dtLanc) {
		this.dtLanc = dtLanc;
	}

	public Date getDtVencto() {
		return dtVencto;
	}

	public void setDtVencto(Date dtVencto) {
		this.dtVencto = dtVencto;
	}

	public Date getDtAux() {
		return dtAux;
	}

	public void setDtAux(Date dtAux) {
		this.dtAux = dtAux;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCondCorporal() {
		return condCorporal;
	}

	public void setCondCorporal(String condCorporal) {
		this.condCorporal = condCorporal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FichaAnimal other = (FichaAnimal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

}
