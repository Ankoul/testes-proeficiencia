package br.com.lelak.teste.model;


public class Instrument {
	private Integer id;
	private String image;
	private String name;
	private User user;
	
	public Instrument() {
	}
	
	public Instrument(Integer id, String image, String name, User user) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
