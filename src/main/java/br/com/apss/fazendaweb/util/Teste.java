package br.com.apss.fazendaweb.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FazendaPU");
		EntityManager manager = factory.createEntityManager();
		manager.close();
		factory.close();
	}
}
