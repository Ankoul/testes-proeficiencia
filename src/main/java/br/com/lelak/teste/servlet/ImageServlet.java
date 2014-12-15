package br.com.lelak.teste.servlet;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lelak.teste.persistence.DAOFactory;
import br.com.lelak.teste.persistence.dao.InstrumentDAO;
import br.com.lelak.teste.util.ExtensionEnum;
import br.com.lelak.teste.util.FileUtils;
import br.com.lelak.teste.util.ImageManager;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filename;
	private byte[] bytes;
       
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instrumentId = request.getParameter("id");
		if(instrumentId != null && !instrumentId.trim().isEmpty()){
			createTempImage(request,response);
		} else {
			createDefaultImage(request, response);
		}
		ExtensionEnum extension = ExtensionEnum.fromBytes(bytes);
		response.setContentType(extension.getMimeType());
		ImageManager.writeOutputStream(response.getOutputStream(), filename);
	}
	
	private void createTempImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String instrumentId = request.getParameter("id");
		bytes = instrumentDAO().findImageById(Long.parseLong(instrumentId));
		if(bytes == null){
			createDefaultImage(request, response);
			return;
		}
		ExtensionEnum extension = ExtensionEnum.fromBytes(bytes);
		String imageName = extension.putExtensionIn("tempImage");
		imageName = FileUtils.createRandomName(imageName);
		filename = getFilename(imageName);
	}

	private void createDefaultImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tempImageName = request.getParameter("tempImage");
		filename = getFilename(tempImageName);
		bytes = FileUtils.toByteArray(filename);
	}

	private InstrumentDAO instrumentDAO() {
		return DAOFactory.createDAO(InstrumentDAO.class);		
	}

	private String getFilename(String tempImage) {
		if(tempImage != null && !tempImage.trim().isEmpty()){
			return getServletContext().getRealPath("resources"+ File.separator +"temp"+ File.separator +tempImage);
		}
		return getClass().getClassLoader().getResource("images/default.png").getFile();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
