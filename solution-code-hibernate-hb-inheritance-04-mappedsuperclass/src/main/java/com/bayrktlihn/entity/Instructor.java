package com.bayrktlihn.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Instructor extends User {

	private double salary;

	public Instructor(String firstName, String lastName, String email, double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
	}

}
