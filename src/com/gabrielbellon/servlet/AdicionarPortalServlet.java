package com.gabrielbellon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabrielbellon.dao.PortalDAO;
import com.gabrielbellon.model.Portal;

public class AdicionarPortalServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Portal p = new Portal();
		p.setName(request.getParameter("nome"));
		p.setLat(Double.parseDouble(request.getParameter("lat")));
		p.setLon(Double.parseDouble(request.getParameter("lon")));
		p.setAddress(request.getParameter("endereco"));

		PortalDAO dao = new PortalDAO();

		dao.insere(p);
		
		RequestDispatcher disp = request.getRequestDispatcher("/cadastro-sucesso.jsp");
		disp.forward(request, response);
	}

}
