package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.RendezVous;

public class RendezVousDaoImpl implements Dao<RendezVous>{
	
	public ArrayList<RendezVous> getRdvByMedecinId(int id){
		try {
			Connection connection = DConnexion.getConnection();
			PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
			String sql = "SELECT * FROM rendezvous WHERE rendezvous.medecinId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<RendezVous> rendezVous = new ArrayList<>();
			while(rs.next()) {
				RendezVous rdv = new RendezVous(
						rs.getInt("idRendezVous"),
						patientDaoImpl.findById(rs.getInt("patientId")),
						utilisateurDaoImpl.findMedecinById(rs.getInt("medecinId")),
						rs.getString("statut"),
						rs.getDate("dateRendezVous")
						);
				rendezVous.add(rdv);
			}
			return rendezVous;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public RendezVous findById(int id) {
		Connection connection;
		PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
		UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM rendezvous WHERE rendezvous.idRendezVous = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new RendezVous(
						rs.getInt("idRendezVous"),
						patientDaoImpl.findById(rs.getInt("patientId")),
						utilisateurDaoImpl.findMedecinById(rs.getInt("medecinId")),
						rs.getString("statut"),
						rs.getDate("dateRendezVous")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<RendezVous> getAll() {
		Connection connection;
		ArrayList<RendezVous> rendezVousList = new ArrayList<RendezVous>();
		try {
			PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM rendezvous;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rendezVousList.add(new RendezVous(
						rs.getInt("idRendezVous"),
						patientDaoImpl.findById(rs.getInt("patientId")),
						utilisateurDaoImpl.findMedecinById(rs.getInt("medecinId")),
						rs.getString("statut"),
						rs.getDate("dateRendezVous")
						));
			}
			return rendezVousList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean save(RendezVous rendezVous) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "INSERT INTO rendezvous(`patientId`, `statut`, `medecinId`, `dateRendezVous`)"
					+ "values(?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, rendezVous.getPatient().getIdPatient());
			ps.setInt(2, rendezVous.getMedecin().getIdUtilisateur());
			ps.setString(3, rendezVous.getStatut());
			ps.setDate(4, rendezVous.getDateRendezVous());
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
	public boolean update(int id, RendezVous rendezVous) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "UPDATE rendezvous set patientId=?, statut=?, medecinId=?, dateRendezVous=? where idRendezVous = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, rendezVous.getPatient().getIdPatient());
			ps.setInt(2, rendezVous.getMedecin().getIdUtilisateur());
			ps.setString(3, rendezVous.getStatut());
			ps.setDate(4, rendezVous.getDateRendezVous());
			ps.setInt(5, id);
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
			String sql = "DELETE FROM rendezvous where rendezvous.idRendezVous = ?";
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
