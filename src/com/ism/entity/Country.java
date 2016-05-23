package com.ism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country {
	
	@Id
	@GeneratedValue
	@Column(name="idCOUNTRY")
	private int idCountry;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="CITY")
	private String city;
	
	public Country(){
		
	}

	public Country(int idCountry, String name, String department, String city) {
		this.idCountry = idCountry;
		this.name = name;
		this.department = department;
		this.city = city;
	}
	
	public Country(String name, String department, String city) {
		this.name = name;
		this.department = department;
		this.city = city;
	}

	public int getIdCountry() {
		return idCountry;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getCity() {
		return city;
	}
	
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Country [idCountry=" + idCountry + ", name=" + name
				+ ", department=" + department + ", city=" + city + "]";
	}
}
