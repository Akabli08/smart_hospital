package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Ordonnance;

public class OrdonnanceDaoImpl implements Dao<Ordonnance>{
	
	public ArrayList<Ordonnance> findByConsId(int consulltationId) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM ordonnance WHERE ordonnance.consultationId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, consulltationId);
			ResultSet rs = ps.executeQuery();
			TraitementDaoImpl daoImpl = new TraitementDaoImpl();
			ArrayList<Ordonnance> ordonnances = new ArrayList<Ordonnance>();
			while(rs.next()) {
				Ordonnance o = new Ordonnance(
						rs.getInt("idOrdonnance"),
						rs.getInt("consultationId"),
						daoImpl.getAllByOrdId(rs.getInt("idOrdonnance")),
						rs.getString("description")
						);
				ordonnances.add(o);
			}
			return ordonnances;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Ordonnance findById(int id) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM ordonnance WHERE ordonnance.idOrdonnance = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			TraitementDaoImpl daoImpl = new TraitementDaoImpl();
			while(rs.next()) {
				return new Ordonnance(
						rs.getInt("idOrdonnance"),
						rs.getInt("consultationId"),
						daoImpl.getAllByOrdId(rs.getInt("idOrdonnance")),
						rs.getString("description")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Ordonnance> getAll() {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM ordonnance;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TraitementDaoImpl daoImpl = new TraitementDaoImpl();
			ArrayList<Ordonnance> ordonnances = new ArrayList<>();
			while(rs.next()) {
				Ordonnance ordonnance = new Ordonnance(
						rs.getInt("idOrdonnance"),
						rs.getInt("consultationId"),
						daoImpl.getAllByOrdId(rs.getInt("idOrdonnance")),
						rs.getString("description")
						);
				ordonnances.add(ordonnance);
			}
			return ordonnances;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Ordonnance t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Ordonnance t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
