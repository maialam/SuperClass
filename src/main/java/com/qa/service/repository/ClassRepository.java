package com.qa.service.repository;

public interface ClassRepository {
	
	String getAllTrainees();

	String createTrainees(String trainee);

	String updateTrainees(Long id, String traineeToUpdate);

	String deleteTrainees(Long id);

}
