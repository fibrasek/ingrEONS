package com.gabrielbellon.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabrielbellon.dao.PortalDAO;
import com.gabrielbellon.model.Portal;

public class AdicionaPortalLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Portal p = new Portal();
		p.setName(request.getParameter("nome"));
		p.setLat(Double.parseDouble(request.getParameter("lat")));
		p.setLon(Double.parseDouble(request.getParameter("lon")));
		p.setAddress(request.getParameter("endereco"));

		PortalDAO dao = new PortalDAO();

		dao.insere(p);
		
		RequestDispatcher disp = request.getRequestDispatcher("/cadastro-sucesso.jsp");
		disp.forward(request, response);
		
		System.out.println("Adicionando portal: " +p.getName());
	}

}
