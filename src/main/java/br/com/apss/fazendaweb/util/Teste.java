package br.com.apss.fazendaweb.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.shiro.crypto.hash.SimpleHash;

import br.com.apss.fazendaweb.model.Usuario;

public class Teste implements Serializable {

	private static final long serialVersionUID = 1L;

	private static EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		factory = Persistence.createEntityManagerFactory("FazendaPU");
		entityManager = factory.createEntityManager();
		return entityManager;
	}

	public static Usuario salvar(Usuario user) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (user.getId() == null) {
				entityManager.persist(user);
			} else {
				user = entityManager.merge(user);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return user;
	}

	public static void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			Usuario usuario = consultarPorId(id);
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	public static Usuario consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		Usuario user = null;
		try {
			user = entityManager.find(Usuario.class, id);
		} finally {
			entityManager.close();
		}
		return user;
	}

	public static void main(String[] args) {
		try {
			/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("FazendaPU");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
			entityManager.close();*/
			Usuario user = new Usuario();
			user.setAtivo(true);
			user.setNome("ADMIN");
			user.setCadastro(new Date());
			user.setEmail("admin@yahoo.com.br");
			SimpleHash hash = new SimpleHash("md5", "1");
			user.setSenha(hash.toHex());
			salvar(user);
			System.out.println("Salvando a usuário.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
