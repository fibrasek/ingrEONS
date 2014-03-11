package com.gabrielbellon.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabrielbellon.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String param = request.getParameter("logica");
    	String nomeClass = "com.gabrielbellon.mvc.logica." + param;
    	
    	try {
			Class<?> c = Class.forName(nomeClass);
			
			Logica logica  = (Logica) c.newInstance();
			logica.executa(request, response);
			
		} catch (Exception e) {
			throw new ServletException("A lógica retornou uma exceção: " + nomeClass, e);
		}
    }

}
