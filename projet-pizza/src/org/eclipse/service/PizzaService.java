package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Pizza;

public class PizzaService {
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaService() {
		pizzas.add(new Pizza(1, "italienne", "4 fromages"));
		pizzas.add(new Pizza(2, "indienne", "indienne"));
		pizzas.add(new Pizza(3, "français", "neptune"));
	}

	public void save(Pizza pizza) {
		pizzas.add(pizza);
	}

	public ArrayList<Pizza> findAll() {
		return pizzas;
	}

	public void remove(int id) {
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getId() == id) {
				pizzas.remove(i);
			}
		}
	}
}
