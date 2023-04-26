package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Patient;

public class PatientDaoImpl implements Dao<Patient>{

	@Override
	public Patient findById(int id) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM patient WHERE patient.idPatient = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Patient(
						rs.getInt("idPatient"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("sexe"),
						rs.getDate("dateNaissance"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("etatCivil"),
						rs.getString("proffesion"),
						rs.getString("adresse"),
						rs.getString("ville"),
						rs.getString("groupeSanguin")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Patient> getAll() {
		Connection connection;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM patient;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				patients.add(new Patient(
								rs.getInt("idPatient"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("sexe"),
								rs.getDate("dateNaissance"),
								rs.getString("email"),
								rs.getString("telephone"),
								rs.getString("etatCivil"),
								rs.getString("proffesion"),
								rs.getString("adresse"),
								rs.getString("ville"),
								rs.getString("groupeSanguin")
								)
							);
						}
			return patients;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Patient p) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "INSERT INTO patient(`nom`, `prenom`, `sexe`,`dateNaissance`, `email`, `telephone`, `etatCivil`, `proffesion`, `adresse`, `ville`, `groupeSanguin`)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getSexe());
			ps.setDate(4, p.getDateNaissance());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getTelephone());
			ps.setString(7, p.getEtatCevil());
			ps.setString(8, p.getProffesion());
			ps.setString(9, p.getAdresse());
			ps.setString(10, p.getVille());
			ps.setString(11, p.getGroupeSanguin());
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
	public boolean update(int id, Patient p) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "UPDATE patient set nom=?, prenom=?, sexe=?, dateNaissance=?, email=?, telephone=?, etatCivil=?, proffesion=?, adresse=?, ville=?, groupeSanguin=?  where idPatient = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getSexe());
			ps.setDate(4, p.getDateNaissance());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getTelephone());
			ps.setString(7, p.getEtatCevil());
			ps.setString(8, p.getProffesion());
			ps.setString(9, p.getAdresse());
			ps.setString(10, p.getVille());
			ps.setString(11, p.getGroupeSanguin());
			ps.setInt(12, id);
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
			String sql = "DELETE FROM patient where patient.idPatient = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if(n != 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
