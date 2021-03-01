package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="employee")
	private List<Address> addresses;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}
	
	
	
	
}
