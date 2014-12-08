package br.com.lelak.teste.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.lelak.teste.model.User;
import br.com.lelak.teste.model.UserMB;

@ManagedBean
@RequestScoped
public class UserController {
	
	public List<User> getList(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "name1", "lastname1", "mail1", "phone1"));
		users.add(new User(2, "name2", "lastname2", "mail2", "phone2"));
		return users;
	}
	
	public void toSave(UserMB user){
		User clone = user.clone();
		System.out.println("salvando "+clone);
	}
	
	public void toDelete(Integer userId){
		System.out.println(userId);
	}
	
	public void toEdit(Integer userId){
		System.out.println(userId);
	}
	
}
