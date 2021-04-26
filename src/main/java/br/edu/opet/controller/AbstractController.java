package br.edu.opet.controller;

import br.edu.opet.util.JSFUtil;

public class AbstractController {

	//Construtor
	public AbstractController() {}
	
	private static final String DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	public void displayErrorMessage(String message) {
		JSFUtil fUtil = new JSFUtil();
		fUtil.sendErrorMessage(message);
	}
	
	public void displayInfoMessage(String message) {
		JSFUtil fUtil = new JSFUtil();
		fUtil.sendInfoMessage(message);
	}

}
