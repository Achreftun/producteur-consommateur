package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.dao.Dao;
import org.eclipse.model.Pizza;
import org.eclipse.model.Pizza;

public class PizzaDao implements Dao<Pizza> {

	@Override
	public Pizza save(Pizza pizza) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into pizza (nom,type) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pizza.getNom());
				ps.setString(2, pizza.getType());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pizza.setId(resultat.getInt(1));
					return pizza;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Pizza pizza) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  pizza  WHERE id = ? ; ");
				ps.setInt(1, pizza.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Pizza update(Pizza pizza) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE  pizza SET nom=? , type=? WHERE id=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pizza.getNom());
				ps.setString(2, pizza.getType());
				ps.setInt(3, pizza.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return pizza;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Pizza findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Pizza WHERE id = ?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int num = result.getInt(1);
					String nom = result.getString(2);
					String type = result.getString(3);
					Pizza pizza = new Pizza(num, nom, type);
					return pizza;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Pizza> findAll() {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Pizza;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					Pizza pizza = new Pizza(id, nom, prenom);
					pizzas.add(pizza);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pizzas;
	}

}
