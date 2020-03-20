package com.bayrktlihn.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "zipcode")
	private String zipcode;
}
