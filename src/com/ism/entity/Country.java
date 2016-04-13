package com.ism.entity;

public class Country {
	
	private int idCountry;
	private String name;
	private String department;
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

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
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
