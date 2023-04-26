package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Utilisateur;

public class UtilisateurDaoImpl implements Dao<Utilisateur>{
	
	
	public Utilisateur findMedecinById(int id) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur WHERE utilisateur.idUtilisateur = ? and utilisateur.role = 'MEDECIN'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Utilisateur(
						rs.getInt("idUtilisateur"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("role")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Utilisateur> getAllMajors(){
		Connection connection;
		ArrayList<Utilisateur> majors = new ArrayList<Utilisateur>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur where utilisateur.role = 'MAJOR';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				majors.add(new Utilisateur(
							rs.getInt("idUtilisateur"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("telephone"),
							rs.getString("role")
								)
							);
						}
			return majors;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Utilisateur> getAllSecretaires(){
		Connection connection;
		ArrayList<Utilisateur> secretaires = new ArrayList<Utilisateur>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur where utilisateur.role = 'SECRETAIRE';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				secretaires.add(new Utilisateur(
							rs.getInt("idUtilisateur"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("telephone"),
							rs.getString("role")
								)
							);
						}
			return secretaires;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Utilisateur> getAllMedecins(){
		Connection connection;
		ArrayList<Utilisateur> medecins = new ArrayList<Utilisateur>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur where utilisateur.role = 'MEDECIN';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				medecins.add(new Utilisateur(
							rs.getInt("idUtilisateur"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("telephone"),
							rs.getString("role")
								)
							);
						}
			return medecins;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Utilisateur findByEmailAndPssword(String email, String password) {
		try {
			Connection connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur WHERE email = ? and password = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			    return new Utilisateur(
			        rs.getInt("idUtilisateur"),
			        rs.getString("nom"),
			        rs.getString("prenom"),
			        rs.getString("email"),
			        rs.getString("password"),
			        rs.getString("telephone"),
			        rs.getString("role")
			    );
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public Utilisateur findById(int id) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur WHERE utilisateur.idUtilisateur = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Utilisateur(
						rs.getInt("idUtilisateur"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("role")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Utilisateur> getAll() {
		Connection connection;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			connection = DConnexion.getConnection();
			String sql = "SELECT * FROM utilisateur;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				utilisateurs.add(new Utilisateur(
							rs.getInt("idUtilisateur"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("telephone"),
							rs.getString("role")
								)
							);
						}
			return utilisateurs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Utilisateur utilisateur) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "INSERT INTO utilisateur(`nom`, `prenom`, `email`, `password`, `telephone`, `role`)"
					+ "values(?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getEmail());
			ps.setString(4, utilisateur.getPassword());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRole());
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
	public boolean update(int id, Utilisateur utilisateur) {
		Connection connection;
		try {
			connection = DConnexion.getConnection();
			String sql = "UPDATE utilisateur set nom=?, prenom=?, email=?, password=?, telephone=?, role=? where idUtilisateur = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getEmail());
			ps.setString(4, utilisateur.getPassword());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRole());
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
			String sql = "DELETE FROM utilisateur where utilisateur.idUtilisateur = ?";
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
