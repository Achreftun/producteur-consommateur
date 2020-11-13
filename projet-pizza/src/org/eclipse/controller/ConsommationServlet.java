package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.service.PizzaService;

@WebServlet("/consommation")
public class ConsommationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaService pizzaService = new PizzaService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pizzas", pizzaService.findAll());
		getServletContext().getRequestDispatcher("/WEB-INF/pizza/consommer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pizzaService.remove(id);
		doGet(request, response);
	}

}
