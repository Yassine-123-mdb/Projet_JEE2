package metier.entities;

import java.io.Serializable;

public class Smartphone implements Serializable{
	private long id;
	private String marque;
	private String couleur;
	private double prix;
	private String ram;
	private String stockage;

	public Smartphone() {
		super();
	}


	public Smartphone(String marque, String couleur, double prix, String ram, String stockage) {
		super();
		this.id = id;
		this.marque = marque;
		this.couleur = couleur;
		this.prix = prix;
		this.ram = ram;
		this.stockage = stockage;
	}


	public long getId() {
		return id;
	}


	public void setId(long l) {
		this.id = l;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getStockage() {
		return stockage;
	}


	public void setStockage(String stockage) {
		this.stockage = stockage;
	}


	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", marque=" + marque + ", couleur=" + couleur + ", prix=" + prix + ", ram="
				+ ram + ", stockage=" + stockage + "]";
	}



	
}

