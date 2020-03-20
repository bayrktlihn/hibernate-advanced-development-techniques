package com.bayrktlihn.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
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

//	@Embedded
	private Address homeAddress;

	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
		@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
		@AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")),
	})
	private Address billingAddress;

	public Student(String firstName, String lastsName, String email) {
		this.firstName = firstName;
		this.lastsName = lastsName;
		this.email = email;
	}

}
