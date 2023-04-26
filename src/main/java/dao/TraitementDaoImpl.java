package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Traitement;

public class TraitementDaoImpl implements Dao<Traitement>{
	
	ArrayList<Traitement> getAllByOrdId(int ordonnanceId){
		try {
			Connection connection = DConnexion.getConnection();
			String sql = "SELECT * FROM traitement WHERE traitement.ordonnanceId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ordonnanceId);
			ArrayList<Traitement> traitements = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Traitement traitement = new Traitement(
						rs.getInt("idTraitement"),
						rs.getInt("ordonnanceId"),
						rs.getString("medicament"),
						rs.getString("quantite"),
						rs.getString("duree_traitement"),
						rs.getString("description")
						);
				traitements.add(traitement);
			}
			return traitements;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Traitement findById(int id) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM traitement WHERE traitement.idTraitement = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Traitement(
						rs.getInt("idTraitement"),
						rs.getInt("ordonnanceId"),
						rs.getString("medicament"),
						rs.getString("quantite"),
						rs.getString("duree_traitement"),
						rs.getString("description")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Traitement> getAll() {
		Connection connection;
		ArrayList<Traitement> traitements = new ArrayList<Traitement>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM traitement;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Traitement traitement = new Traitement(
						rs.getInt("idTraitement"),
						rs.getInt("ordonnanceId"),
						rs.getString("medicament"),
						rs.getString("quantite"),
						rs.getString("duree_traitement"),
						rs.getString("description")
						);
				traitements.add(traitement);
			}
			return traitements;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Traitement traitement) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "INSERT INTO rendezvous(`medicament`, `quantite`, `date`, `description`)"
					+ "values(?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(2, traitement.getMedicament());
			ps.setString(3, traitement.getQuantite());
			ps.setString(5, traitement.getDescription());
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(int id, Traitement traitement) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "UPDATE traitement set medicament=?, quantite=?, date=?, description=? where idTraitement = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(2, traitement.getMedicament());
			ps.setString(3, traitement.getQuantite());
			ps.setString(5, traitement.getDescription());
			ps.setInt(6, id);
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		try {
			Connection connection = DConnexion.getConnection();
			String sql = "DELETE FROM traitement where traitement.idTraitement = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
