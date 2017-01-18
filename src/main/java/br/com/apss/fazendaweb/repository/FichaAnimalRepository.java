package br.com.apss.fazendaweb.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.apss.fazendaweb.model.FichaAnimal;
import br.com.apss.fazendaweb.model.filter.FichaAnimalFilter;
import br.com.apss.fazendaweb.util.NegocioException;


public class FichaAnimalRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public FichaAnimal save(FichaAnimal e) {
		return em.merge(e);
	}

	
	public void remove(FichaAnimal fichaAnimal) {
		try {
			fichaAnimal = porId(fichaAnimal.getId());
			em.remove(fichaAnimal);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Registro n�o pode ser exclu�do pois possui vinculo com outras tabelas.");
		}
	}

	public FichaAnimal porId(Long value) {
		System.out.println("repository "+value);
		return em.find(FichaAnimal.class, value);
	}

	public List<FichaAnimal> listarTodos() {
		return em.createQuery("from FichaAnimal order by nome", FichaAnimal.class).getResultList();
	}

	public FichaAnimal porNome(String nome) {
		try {
			return em.createQuery("from FichaAnimal where nome = :nome", FichaAnimal.class)
					.setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<FichaAnimal> filtrados(FichaAnimalFilter filtro) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FichaAnimal.class);

		if (filtro.getIdDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a
			// filtro.IdDe
			criteria.add(Restrictions.ge("id", filtro.getIdDe()));
		}

		if (filtro.getIdAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a
			// filtro.IdDe
			criteria.add(Restrictions.le("id", filtro.getIdAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		if (filtro.getAtivo().equals("ATIVO")) {
			criteria.add(Restrictions.ge("status", true));
		}
		if (filtro.getAtivo().equals("INATIVO")) {
			criteria.add(Restrictions.le("status", false));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FichaAnimal> grupoCondicao(FichaAnimal op) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FichaAnimal.class);


		return criteria.addOrder(Order.asc("nome")).list();
	}


}