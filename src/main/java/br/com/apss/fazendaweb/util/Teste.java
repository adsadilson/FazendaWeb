package br.com.apss.fazendaweb.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Ignore;


public class Teste implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Ignore
	public void gerarTabela() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FazendaPU");
		EntityManager manager = factory.createEntityManager();
		manager.close();
		factory.close();
	}
	
}
