package com.finzly.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.finzly.demo.entity.PropertiesManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PropertiesDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	PropertiesManager propertiesManager;
	@Autowired
	SessionFactory factory;

	public List<PropertiesManager> getNameFromTable() {
		//System.out.println("IN DAO ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PropertiesManager> query = criteriaBuilder.createQuery(PropertiesManager.class);
		Root<PropertiesManager> root = query.from(PropertiesManager.class);
//		Predicate firstNames = criteriaBuilder.equal(root.get("firstName"), "sahid");
//		query.where(firstNames);
		
		query.select(root);
		return entityManager.createQuery(query).getResultList();

	}	
	
	public String setNameFromPropeties(PropertiesManager pm) {
		Session session = factory.openSession();
		try{
			session.save(pm);
			session.beginTransaction().commit();
			session.close();
			return "Added";
		}catch (Exception e) {
		   System.out.println(e);
		}
		finally {
			session.close();
		}
		return "Not Added";		
	}

	public String setNameFromAPI(PropertiesManager pm) {
		Session session = factory.openSession();
		try{
			session.save(pm);
			session.beginTransaction().commit();
			session.close();
			return "added";
		}catch (Exception e) {
			return ""+e;
		}
	}
}
