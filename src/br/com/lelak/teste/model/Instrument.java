package br.com.lelak.teste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Instrument implements Serializable{

	private static final long serialVersionUID = 7582414649100351188L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String image;

	@Column(length = 50)
	private String name;
	
	@ManyToOne
	private User user;
	
	public Instrument() {
	}
	
	public Instrument(Long id, String image, String name, User user) {
		super();
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
		return image;
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
}
