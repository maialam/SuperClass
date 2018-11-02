package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassDBRepository implements ClassRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Class a");
		Collection<Class> trainees = (Collection<Class>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createTrainees(String trainee) {
		Class aTrainee = util.getObjectForJSON(trainee, Class.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	
	@Transactional(REQUIRED)
	public String updateTrainees(Long id, String traineeToUpdate) {
		Class updatedClass = util.getObjectForJSON(traineeToUpdate, Class.class);
		Class traineeFromDB = findTrainee(id);
		if (traineeToUpdate != null) {
			traineeFromDB = updatedClass;
			manager.merge(traineeFromDB);
		}
		return "{\"message\": \"trainee sucessfully updated\"}";
	}

	
	@Transactional(REQUIRED)
	public String deleteTrainees(Long id) {
		Class traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}
	
	private Class findTrainee(Long id) {
		return manager.find(Class.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}