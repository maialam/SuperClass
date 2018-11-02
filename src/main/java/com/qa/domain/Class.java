package com.qa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Classroom")
public class Class {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String firstName;
	private String secondName;
    @OneToMany( cascade = CascadeType.ALL, fetch = Fetch.Type.EAGER)
	@JoinColumn(name = "trainee_id")
    private List<Trainee> trainee;
		
    public Class() {

	}
    
	public Class(String firstName, String secondName, List<Class> classRoom) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.classRoom = classRoom;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<Class> getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(List<Class> trainees) {
		this.classRoom = trainees;
	}




	

}