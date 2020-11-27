package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.UtilisateurDao;
import org.eclipse.model.Utilisateur;

public class UtilisateurService {
	private UtilisateurDao utilisateurDao= new UtilisateurDao();

	public UtilisateurService() {
	}
	
	public Utilisateur findByNomAndPrenom(String nom, String prenom) {

		return utilisateurDao.findByNomAndPrenom(nom, prenom).get(0);
	}
}
