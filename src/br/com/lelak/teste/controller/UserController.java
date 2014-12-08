package br.com.lelak.teste.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.lelak.teste.model.User;
import br.com.lelak.teste.model.UserMB;
import br.com.lelak.teste.persistence.DAOFactory;
import br.com.lelak.teste.persistence.UserDAO;

@ManagedBean
@RequestScoped
public class UserController {
	
	public List<User> getList(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1l, "name1", "lastname1", "mail1", "phone1"));
		users.add(new User(2l, "name2", "lastname2", "mail2", "phone2"));
		return users;
	}

	@PostConstruct
	private void testeDAO() {
		try {
			UserDAO userDAO = DAOFactory.createDAO(UserDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toSave(UserMB user){
		User clone = user.clone();
		System.out.println("salvando "+clone);
	}
	
	public void toDelete(Long userId){
		System.out.println(userId);
	}
	
	public void toEdit(Long userId){
		System.out.println(userId);
	}
	
}
