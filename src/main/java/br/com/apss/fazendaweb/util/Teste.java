package br.com.apss.fazendaweb.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FazendaPU");
		EntityManager manager = factory.createEntityManager();

		/*EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Pessoa cliente = new Pessoa();
		cliente.setNome("RONALDO OLIVEIRA GOMES");
		cliente.setEmail("ronaldog@yahoo.com.br");
		cliente.setCpfCnpj("323.223.113-10");
		cliente.setTipo(TipoDoc.F);

		Endereco endereco = new Endereco();
		endereco.setTipo(TipoEndereco.RES);
		endereco.setLogradouro("Rua sete de setembro");
		endereco.setNumero("89");
		endereco.setCidade("poções");
		endereco.setUf(Estado.BAHIA);
		endereco.setCep("45260-000");
		endereco.setPessoa(cliente);

		cliente.getEnderecos().add(endereco);
		
		Endereco endereco2 = new Endereco();
		endereco2.setTipo(TipoEndereco.COM);
		endereco2.setLogradouro("Avenida Vitoria da conquista");
		endereco2.setNumero("103");
		endereco2.setCidade("poções");
		endereco2.setUf(Estado.BAHIA);
		endereco2.setCep("45260-000");
		endereco2.setPessoa(cliente);

		cliente.getEnderecos().add(endereco2);

		manager.persist(cliente);

		trx.commit();*/
		manager.close();
		factory.close();
	}
}
