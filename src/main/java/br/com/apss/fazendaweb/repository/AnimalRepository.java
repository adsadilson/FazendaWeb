package br.com.apss.fazendaweb.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.apss.fazendaweb.model.Animal;
import br.com.apss.fazendaweb.util.NegocioException;


public class AnimalRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Animal save(Animal e) {
		return em.merge(e);
	}

	
	public void remove(Animal animal) {
		try {
			animal = porId(animal.getId());
			em.remove(animal);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Animal não pode ser excluído pois possui vinculo com outra tabela.");
		}
	}

	public Animal porId(Long value) {
		return em.find(Animal.class, value);
	}

	public List<Animal> listarTodos() {
		return em.createQuery("from Animal order by nome", Animal.class).getResultList();
	}

	public Animal porNome(String nome) {
		try {
			return em.createQuery("from Animal where nome = :nome", Animal.class)
					.setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Animal> grupoCondicao(Animal op) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Animal.class);

		if (op.getStatus().equals("ATIVO")) {
			criteria.add(Restrictions.ge("status", true));
		}
		if (op.getStatus().equals("INATIVO")) {
			criteria.add(Restrictions.le("status", false));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}


}
