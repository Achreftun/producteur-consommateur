package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Utilisateur;
import org.eclipse.model.Utilisateur;

public class UtilisateurDao implements Dao<Utilisateur> {

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into utilisateur (nom,prenom,type) values (?,?, ?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, utilisateur.getType());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					utilisateur.setId(resultat.getInt(1));
					return utilisateur;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  utilisateur  WHERE id = ? ; ");
				ps.setInt(1, utilisateur.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE  utilisateur SET nom=?, prenom=?, type=? WHERE id=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, utilisateur.getType());
				ps.setInt(4, utilisateur.getId());
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return utilisateur;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Utilisateur findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur WHERE id = ?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int num = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String type = result.getString(4);
					Utilisateur utilisateur = new Utilisateur(num, nom, prenom, type);
					return utilisateur;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String type = result.getString(4);
					Utilisateur utilisateur = new Utilisateur(id, nom, prenom, type);
					utilisateurs.add(utilisateur);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateurs;
	}

	public ArrayList<Utilisateur> findByNomAndPrenom(String nom, String prenom) {
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilisateur WHERE nom = ? AND prenom = ?;");
				ps.setString(1, nom);
				ps.setString(2, prenom);

				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String n = result.getString(2);
					String p = result.getString(3);
					String type = result.getString(4);
					Utilisateur utilisateur = new Utilisateur(id, nom, prenom, type);
					utilisateurs.add(utilisateur);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateurs;
	}
}
