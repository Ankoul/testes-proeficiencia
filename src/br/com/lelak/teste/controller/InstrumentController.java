package br.com.lelak.teste.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.lelak.teste.model.Instrument;
import br.com.lelak.teste.model.InstrumentMB;
import br.com.lelak.teste.model.User;

@ManagedBean
@RequestScoped
public class InstrumentController {
	
	public List<Instrument> getList(){
		List<Instrument> instruments = new ArrayList<Instrument>();
		instruments.add(new Instrument(1, "view/image/1.jpg", "instrumento1", new User("usuario1")));
		instruments.add(new Instrument(2, "view/image/2.jpg", "instrumento2", new User("usuario2")));
		return instruments;
	}
	
	public void toSave(InstrumentMB instrument){
		System.out.println("salvando "+instrument.getName());
	}

}
