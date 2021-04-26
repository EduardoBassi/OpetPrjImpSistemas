package br.edu.opet.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AbstractFilter {

	//Construtor
	public AbstractFilter() {}

	protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login");
		dispatcher.forward(request, response);
	}
	
	protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("acessoNegado");
		dispatcher.forward(request, response);
	}
	
	protected void cadastroUsuario(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroUsuario");
		dispatcher.forward(request, response);
	}
	
}
