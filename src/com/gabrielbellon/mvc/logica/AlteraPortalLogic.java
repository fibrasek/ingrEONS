package com.gabrielbellon.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabrielbellon.dao.PortalDAO;
import com.gabrielbellon.model.Portal;

public class AlteraPortalLogic implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Portal p = new Portal();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setLat(Double.parseDouble(request.getParameter("lat")));
		p.setLon(Double.parseDouble(request.getParameter("lon")));
		p.setAddress(request.getParameter("address"));
		
		PortalDAO dao = new PortalDAO();
		
		dao.update(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/bem-vindo.jsp");
		rd.forward(request, response);
		
		System.out.println("Atualizando portal: " + p.getId() + " - " + p.getName());
	}

}
