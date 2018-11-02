package com.qa.service.business;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.service.repository.ClassRepository;

public class ClassServiceImpl implements ClassService {

	private static final Logger LOGGER = Logger.getLogger(ClassService.class);

	@Inject
	private ClassRepository repo;

	public String getAllTrainees() {
		LOGGER.info("In ClassServiceImpl getAllTrainees ");
		return repo.getAllTrainees();
	}

	public String addTrainee(String Trainee) {
		return repo.createTrainees(Trainee);
	}

	public String updateTrainee(Long id, String Trainee) {
		return repo.updateTrainees(id, Trainee);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainees(id);

	}

	public void setRepo(ClassRepository repo) {
		this.repo = repo;
	}
}