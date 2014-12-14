package br.com.lelak.teste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Instrument implements Serializable, Cloneable {

	private static final long serialVersionUID = 7582414649100351188L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 400000)
	private String image;

	@Column(length = 50)
	private String name;
	
	@ManyToOne
	private User user;
	
	public Instrument() {
	}

	public Instrument(Long id, String image, String name, User user) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image != null ? image : "images/default.png";
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Instrument clone(){
		Instrument clone = new Instrument();
		clone.id = id;
		clone.name = name;
		clone.image = image;
		clone.user = user;
		return clone;
	}
}
