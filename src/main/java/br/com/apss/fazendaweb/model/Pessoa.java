package br.com.apss.fazendaweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.apss.fazendaweb.enums.Estado;
import br.com.apss.fazendaweb.enums.Sexo;

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "PESSOA_ID", sequenceName = "PESSOA_SEQ", allocationSize = 1)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PESSOA_ID")
	private Long id;

	@Column(name = "nome", nullable = true, length = 80)
	private String nome;

	@Column(name = "cpf_cnpj", nullable = true, length = 20)
	private String cpfCnpj;

	@Column(name = "email", nullable = false, length = 200)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento", nullable = false, length = 10)
	private Date nascimento;

	@Column(name = "nacionalidade", nullable = false, length = 80)
	private String nacionalidade;

	@Column(name = "celular", nullable = false, length = 20)
	private String celular;

	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = true, length = 1)
	private Sexo sexo;

	@ManyToOne
	@JoinColumn(name = "estado_civil_id")
	private EstadoCivil estadoCivil;

	@Column(name = "conjuge", nullable = false, length = 80)
	private String conjuge;

	@Column(name = "nome_pai", nullable = false, length = 80)
	private String pai;

	@Column(name = "nome_mae", nullable = true, length = 80)
	private String mae;

	@Column(name = "cep", nullable = true, length = 10)
	private String cep;

	@Column(name = "endereco", nullable = true, length = 80)
	private String endereco;

	@Column(name = "num", nullable = true, length = 10)
	private String numero;

	@Column(name = "complemento", nullable = false, length = 80)
	private String complemento;

	@Column(name = "bairro", nullable = true, length = 80)
	private String bairro;

	@Column(name = "uf", nullable = true, length = 2)
	private String uf;

	@Column(name = "cidade", nullable = true, length = 80)
	private String cidade;

	@Column(name = "tipo_doc", nullable = true, length = 80)
	private String tipoDoc;

	@Column(name = "num_doc", nullable = true, length = 25)
	private String numDoc;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_emissao", nullable = true, length = 10)
	private Date dataEmissao;

	@Column(name = "orgao_emissor", nullable = true, length = 25)
	private String orgaoEmissor;

	@Enumerated(EnumType.STRING)
	@Column(name = "uf_emissor", nullable = true, length = 2)
	private Estado ufEmissor;

	@Column(name = "num_seguranca", nullable = false, length = 25)
	private String num_seguranca;

	@Column(name = "trabalha", nullable = true, length = 3)
	private String trabalha;

	@Column(name = "ocupacao", nullable = false, length = 80)
	private String ocupacao;

	@Column(name = "empresa", nullable = false, length = 80)
	private String empresa;

	@Column(name = "emp_telefone", nullable = false, length = 20)
	private String empTelefone;

	@Column(name = "emp_cep", nullable = true, length = 10)
	private String empCep;

	@Column(name = "emp_endereco", nullable = true, length = 80)
	private String empEndereco;

	@Column(name = "emp_num", nullable = true, length = 10)
	private String empNumero;

	@Column(name = "emp_complemento", nullable = false, length = 80)
	private String empComplemento;

	@Column(name = "emp_bairro", nullable = true, length = 80)
	private String empBairro;

	@Column(name = "emp_uf", nullable = true, length = 2)
	private String empUf;

	@Column(name = "emp_cidade", nullable = true, length = 80)
	private String empCidade;

	@Column(name = "nome_banco", nullable = false, length = 80)
	private String banco;

	@Column(name = "tipo_conta", nullable = false, length = 80)
	private String tipoConta;

	@Column(name = "agencia", nullable = false, length = 10)
	private String agencia;

	@Column(name = "num_conta", nullable = false, length = 30)
	private String numConta;

	@Column(name = "renda", precision = 12, scale = 2)
	private BigDecimal renda;

	@Column(name = "tipo_pessoa", length = 10)
	private String tipoPessoa;

	@Column(name = "status", nullable = false, length = 1)
	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Estado getUfEmissor() {
		return ufEmissor;
	}

	public void setUfEmissor(Estado ufEmissor) {
		this.ufEmissor = ufEmissor;
	}

	public String getNum_seguranca() {
		return num_seguranca;
	}

	public void setNum_seguranca(String num_seguranca) {
		this.num_seguranca = num_seguranca;
	}

	public String getTrabalha() {
		return trabalha;
	}

	public void setTrabalha(String trabalha) {
		this.trabalha = trabalha;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmpTelefone() {
		return empTelefone;
	}

	public void setEmpTelefone(String empTelefone) {
		this.empTelefone = empTelefone;
	}

	public String getEmpCep() {
		return empCep;
	}

	public void setEmpCep(String empCep) {
		this.empCep = empCep;
	}

	public String getEmpEndereco() {
		return empEndereco;
	}

	public void setEmpEndereco(String empEndereco) {
		this.empEndereco = empEndereco;
	}

	public String getEmpNumero() {
		return empNumero;
	}

	public void setEmpNumero(String empNumero) {
		this.empNumero = empNumero;
	}

	public String getEmpComplemento() {
		return empComplemento;
	}

	public void setEmpComplemento(String empComplemento) {
		this.empComplemento = empComplemento;
	}

	public String getEmpBairro() {
		return empBairro;
	}

	public void setEmpBairro(String empBairro) {
		this.empBairro = empBairro;
	}

	public String getEmpUf() {
		return empUf;
	}

	public void setEmpUf(String empUf) {
		this.empUf = empUf;
	}

	public String getEmpCidade() {
		return empCidade;
	}

	public void setEmpCidade(String empCidade) {
		this.empCidade = empCidade;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
		Pessoa other = (Pessoa) obj;
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
