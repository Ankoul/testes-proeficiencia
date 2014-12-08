package br.com.lelak.teste.model;

import br.com.lelak.teste.exception.CloneNotSupportedRuntimeException;


public class User implements Cloneable {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String phone;

	public User() {
		id = 0;
		name = "";
		lastName = "";
		email = "";
		phone = "";
	}

	public User(int id, String name, String lastName, String mail, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = mail;
		this.phone = phone;
	}

	public User(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public User clone(){
		try {
			return (User) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new CloneNotSupportedRuntimeException();
		}
	}

}
