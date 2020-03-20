package com.bayrktlihn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "images" })
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastsName;

	@Column(name = "email")
	private String email;

	@ElementCollection
	@CollectionTable(name = "image", joinColumns = @JoinColumn(name = "student_id"))
	@OrderColumn
	@Column(name = "file_name")
	private List<String> images = new ArrayList<String>();

	public Student(String firstName, String lastsName, String email) {
		this.firstName = firstName;
		this.lastsName = lastsName;
		this.email = email;
	}

}
