package br.com.lelak.teste.managedBean;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.util.Base64;

import br.com.lelak.teste.model.Instrument;
import br.com.lelak.teste.persistence.DAOFactory;
import br.com.lelak.teste.persistence.dao.InstrumentDAO;

@ManagedBean
@ViewScoped
public class InstrumentMB extends Instrument {
	
	private static final boolean LINE_SEPARATOR_FALSE = false;
	private static final long serialVersionUID = 3896691647663920684L;
	
	public List<Instrument> getList(){
		return instrumentDAO().findAll();
	}
	
	public void toSave(){
		instrumentDAO().save(clone());
	}
	
	private InstrumentDAO instrumentDAO(){
		return DAOFactory.createDAO(InstrumentDAO.class);
	}

	
	public void fileUploadHandler(FileUploadEvent event) throws Exception{
		UploadedFile file = event.getFile();
		
		InputStream inputstream = file.getInputstream();
		byte[] imageAsByte = IOUtils.toByteArray(inputstream);
		BufferedImage bufferedImage = ImageIO.read(inputstream);
		String imageAsString = Base64.encodeToString(imageAsByte, LINE_SEPARATOR_FALSE);
		setImage(imageAsString);
	}

}
