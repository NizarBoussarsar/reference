package tn.ens.esprit.reference.repositories.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.ens.esprit.reference.entities.MyEntity;
import tn.ens.esprit.reference.repositories.custom.interfaces.MyEntityRepositoryCustom;

public class MyEntityRepositoryImpl implements MyEntityRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public MyEntity findOneByName(String name) {
		{
			MyEntity myEntity = null;
			try {
				String jpql = "select m from MyEntity m where m.name = :param1";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("param1", name);
				myEntity = (MyEntity) query.getSingleResult();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			return myEntity;
		}
	}

	public MyEntity findOneByUrl(String url) {
		{
			MyEntity myEntity = null;
			try {
				String jpql = "select m from MyEntity m where m.url = :param1";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("param1", url);
				myEntity = (MyEntity) query.getSingleResult();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			return myEntity;
		}
	}

}
