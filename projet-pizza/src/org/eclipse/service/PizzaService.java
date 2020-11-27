package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.PizzaDao;
import org.eclipse.model.Pizza;

public class PizzaService {
	private PizzaDao pizzaDao = new PizzaDao();

	public PizzaService() {

	}

	public Pizza save(Pizza pizza) {
		return pizzaDao.save(pizza);
	}

	public ArrayList<Pizza> findAll() {
		return (ArrayList<Pizza>) pizzaDao.findAll();
	}

	public void remove(int id) {
		pizzaDao.remove(pizzaDao.findById(id));
	}
}
