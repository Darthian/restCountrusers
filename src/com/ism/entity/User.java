package com.ism.entity;

public class User {

	private int idUser;
	private String name;
	private String password;
	
	public User(){
		
	}
	
	public User(int idUser, String name, String password) {
		this.idUser = idUser;
		this.name = name;
		this.password = password;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", password="
				+ password + "]";
	}
}
