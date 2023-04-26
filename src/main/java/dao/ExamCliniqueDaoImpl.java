package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.ExamenClinique;

public class ExamCliniqueDaoImpl implements Dao<ExamenClinique>{
	
	public ArrayList<ExamenClinique> findByConsId(int consultationId) {
		try {
			Connection connection = DConnexion.getConnection();
			String sql = "SELECT * FROM examenclinique WHERE examenclinique.consultationId = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, consultationId);
			ResultSet rs = ps.executeQuery();
			ArrayList<ExamenClinique> cliniques = new ArrayList<>();
			while(rs.next()) {
				ExamenClinique ec = new ExamenClinique(
						rs.getInt("idExamenclinique"),
						rs.getInt("patientId"),
						rs.getInt("poid"),
						rs.getInt("hauteur"),
						rs.getInt("temperature"),
						rs.getInt("pression"),
						rs.getString("description"),
						rs.getDate("dateExamenClinique")
						);
				cliniques.add(ec);
			}
			return cliniques;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ExamenClinique findById(int id) {

		try {
			Connection connection = DConnexion.getConnection();
			String sql = "SELECT * FROM examclinique WHERE idExamclinique = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new ExamenClinique(
						rs.getInt("idExamclinique"),
						rs.getInt("patientId"),
						rs.getInt("poid"),
						rs.getInt("hauteur"),
						rs.getInt("temperature"),
						rs.getInt("pression"),
						rs.getString("description"),
						rs.getDate("dateExamenClinique")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ExamenClinique> getAll() {
		try {
			Connection connection = DConnexion.getConnection();
			String sql = "SELECT * FROM examclinique;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ExamenClinique> examenCliniques = new ArrayList<>();
			while(rs.next()) {
				ExamenClinique examenClinique = new ExamenClinique(
						rs.getInt("idExamclinique"),
						rs.getInt("patientId"),
						rs.getInt("poid"),
						rs.getInt("hauteur"),
						rs.getInt("temperature"),
						rs.getInt("pression"),
						rs.getString("description"),
						rs.getDate("dateExamenClinique")
						);
				examenCliniques.add(examenClinique);
			}
			return examenCliniques;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(ExamenClinique t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, ExamenClinique t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
