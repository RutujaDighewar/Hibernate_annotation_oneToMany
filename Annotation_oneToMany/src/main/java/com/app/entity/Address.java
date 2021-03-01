package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String city;
	
	private int pincode;
	
	@Column(name = "eid" , updatable=false, insertable=false)
	private int eid;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "eid")
	private Employee employee;

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", pincode=" + pincode + ", eid=" + eid + "]";
	}

	
	
}
