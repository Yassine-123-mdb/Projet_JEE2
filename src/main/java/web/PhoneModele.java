package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Smartphone;

public class PhoneModele {
	private String motCle;
	List<Smartphone> phones = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Smartphone> getProduits() {
		return phones;
	}

	public void setProduits(List<Smartphone> produits) {
		this.phones = produits;
	}
}