package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Smartphone;

public class SmartPhoneDaoImpl implements IPhoneDao {
	@Override
	public Smartphone save(Smartphone p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO smartphone(marque,couleur,prix,ram,stockage) VALUES(?,?,?,?,?)");
			ps.setString(1, p.getMarque());
			ps.setDouble(3, p.getPrix());
			ps.setString(2, p.getCouleur());
			ps.setString(4, p.getRam());
			ps.setString(5, p.getStockage());
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM smartphone");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Smartphone> PhonesParMC(String mc) {
		List<Smartphone> prods = new ArrayList<Smartphone>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from smartphone where marque LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Smartphone p = new Smartphone();
				p.setId(rs.getLong("id"));
				p.setMarque(rs.getString("marque"));
				p.setPrix(rs.getDouble("prix"));
				p.setCouleur(rs.getString("couleur"));
				p.setRam(rs.getString("ram"));
				p.setStockage(rs.getString("stockage"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Smartphone getPhone(Long id) {

		Connection conn = SingletonConnection.getConnection();
		Smartphone p = new Smartphone();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from smartphone where id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("id"));
				p.setMarque(rs.getString("marque"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setCouleur(rs.getString("couleur"));
				p.setRam(rs.getString("ram"));
				p.setStockage(rs.getString("stockage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public Smartphone updatePhone(Smartphone p) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("UPDATE smartphone SET marque=?,PRIX=?,couleur=?,ram=?,stockage=? WHERE id=?");
	ps.setString(1, p.getMarque());
	ps.setDouble(2, p.getPrix());
	ps.setString(3, p.getCouleur());
	ps.setString(4, p.getRam());
	ps.setString(5, p.getStockage());
	ps.setLong(6, p.getId());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

	@Override
	public void deletePhone(Long id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM smartphone WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
