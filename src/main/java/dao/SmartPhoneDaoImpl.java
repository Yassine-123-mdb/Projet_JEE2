package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Smartphone;
import util.JPAutil;

public class SmartPhoneDaoImpl implements IPhoneDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_SmartPhone");

	@Override
	public Smartphone save(Smartphone p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
	}

@Override
public List<Smartphone> PhonesParMC(String mc) {
List<Smartphone> prods = entityManager.createQuery("select s from Smartphone s where s.marque like :mc").setParameter("mc", "%"+mc+"%").getResultList();

return prods;
}

	@Override
	public Smartphone getPhone(Long id) {
		return entityManager.find(Smartphone.class, id);
	}

	@Override
	public Smartphone updatePhone(Smartphone p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
	}

	@Override
	public void deletePhone(Long id) {
		Smartphone produit = entityManager.find(Smartphone.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(produit);
		entityManager.getTransaction().commit();
	}
}