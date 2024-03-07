package dao;

import java.util.List;

import metier.entities.Smartphone;

public class TestDao {
	public static void main(String[] args) {
		SmartPhoneDaoImpl pdao = new SmartPhoneDaoImpl();
		Smartphone prod = pdao.save(new Smartphone("iphone 8 plus","noire",2800,"6gb","128gb"));
		System.out.println(prod);
		List<Smartphone> prods = pdao.PhonesParMC("HP");
		for (Smartphone p : prods)
			System.out.println(p);
	}
}