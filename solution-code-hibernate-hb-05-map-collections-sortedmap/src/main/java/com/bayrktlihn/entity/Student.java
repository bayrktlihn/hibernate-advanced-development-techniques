package com.bayrktlihn.entity;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

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
	@CollectionTable(name = "image")
	@MapKeyColumn(name = "file_name")
	@Column(name = "image_name")
//	@OrderBy
	@SortComparator(ReverseStringComparator.class)
	private SortedMap<String, String> images = new TreeMap<String, String>();

	public Student(String firstName, String lastsName, String email) {
		this.firstName = firstName;
		this.lastsName = lastsName;
		this.email = email;
	}

	public static class ReverseStringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}

	}

}
