package br.com.lelak.teste.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class InstrumentMB  extends Instrument {

	private static final long serialVersionUID = -5283350390209830165L;
	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public void reset(){
		setName("");
		setFile(null);
		setUser(null);
	}

}
