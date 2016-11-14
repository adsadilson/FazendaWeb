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

import br.com.apss.fazendaweb.model.EstadoCivil;
import br.com.apss.fazendaweb.util.NegocioException;


public class EstadoCivilRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public EstadoCivil save(EstadoCivil e) {
		return em.merge(e);
	}

	
	public void remove(EstadoCivil categoria) {
		try {
			categoria = porId(categoria.getId());
			em.remove(categoria);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Estado Civil não pode ser excluído pois possui vinculo com outra tabela.");
		}
	}

	public EstadoCivil porId(Long value) {
		System.out.println("repository "+value);
		return em.find(EstadoCivil.class, value);
	}

	public List<EstadoCivil> listarTodos() {
		return em.createQuery("from EstadoCivil order by nome", EstadoCivil.class).getResultList();
	}

	public EstadoCivil porNome(String nome) {
		try {
			return em.createQuery("from EstadoCivil where nome = :nome", EstadoCivil.class)
					.setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EstadoCivil> grupoCondicao(EstadoCivil op) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(EstadoCivil.class);

		if (op.getStatus().equals("ATIVO")) {
			criteria.add(Restrictions.ge("status", true));
		}
		if (op.getStatus().equals("INATIVO")) {
			criteria.add(Restrictions.le("status", false));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}


}
