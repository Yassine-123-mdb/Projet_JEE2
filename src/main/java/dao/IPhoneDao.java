package dao;

import java.util.List;

import metier.entities.Smartphone;

public interface IPhoneDao {
	public Smartphone save(Smartphone p);

	public List<Smartphone> PhonesParMC(String mc);

	public Smartphone getPhone(Long id);

	public Smartphone updatePhone(Smartphone p);

	public void deletePhone(Long id);
}