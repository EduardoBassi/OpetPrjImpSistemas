package br.edu.opet.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	//Construtor
	public JSFUtil() {}
	
	public void sendInfoMessage(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
		addMessageToJsfContext(facesMessage);
	}

	public void sendErrorMessage(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
		addMessageToJsfContext(facesMessage);
	}
	
	private FacesMessage createMessage(FacesMessage.Severity severity, String message) {
		return new FacesMessage(severity, message, message);
	}
	
	private void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
}
