package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String trainee;
	
	public String getTrainee() {
		
		return trainee;
		
	}
	
	public void setTrainee(String trainee) {
		
		this.trainee = trainee;
		
	}
	
	public Long getId() {
		return id;
		
	}
	
	public void setId(Long id) {
		
		this.id = id;
		
	}

}
