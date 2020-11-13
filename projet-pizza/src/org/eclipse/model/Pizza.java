package org.eclipse.model;

public class Pizza {
	private int id;
	private String type;
	private String nom;

	public Pizza() {
		super();
	}

	public Pizza(int id, String type, String nom) {
		super();
		this.id = id;
		this.type = type;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", type=" + type + ", nom=" + nom + "]";
	}

}
