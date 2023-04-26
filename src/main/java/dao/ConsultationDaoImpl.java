package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Consultation;


public class ConsultationDaoImpl implements Dao<Consultation>{
	
	public ArrayList<Consultation> findByPatientId(int patientId){
		try{
			Connection connection = DConnexion.getConnection();
			RendezVousDaoImpl daoImpl = new RendezVousDaoImpl();
			ExamCliniqueDaoImpl daoImpl2 = new ExamCliniqueDaoImpl();
			OrdonnanceDaoImpl daoImpl3 = new OrdonnanceDaoImpl();
			String sql = "SELECT * FROM consultation WHERE patientId = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Consultation> consultations = new ArrayList<>(); 
			while(rs.next()) {
				Consultation consultation = new Consultation(
						rs.getInt("idConsultation"),
						rs.getInt("patientid"),
						daoImpl.findById(rs.getInt("rendezvousId")),
						rs.getString("titre"),
						daoImpl2.findByConsId(rs.getInt("idConsultation")),
						daoImpl3.findByConsId(rs.getInt("idConsultation")));
				consultations.add(consultation);
			}
			return consultations;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Consultation findById(int id) {
		try{
			Connection connection = DConnexion.getConnection();
			RendezVousDaoImpl daoImpl = new RendezVousDaoImpl();
			ExamCliniqueDaoImpl daoImpl2 = new ExamCliniqueDaoImpl();
			OrdonnanceDaoImpl daoImpl3 = new OrdonnanceDaoImpl();
			String sql = "SELECT * FROM consultation WHERE idConsultation = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Consultation(
						rs.getInt("idConsultation"),
						rs.getInt("patientid"),
						daoImpl.findById(rs.getInt("rendezvousId")),
						rs.getString("titre"),
						daoImpl2.findByConsId(rs.getInt("consultationId")),
						daoImpl3.findByConsId(rs.getInt("consultationId"))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Consultation> getAll() {
		try {
			Connection connection = DConnexion.getConnection();
			RendezVousDaoImpl daoImpl = new RendezVousDaoImpl();
			ExamCliniqueDaoImpl daoImpl2 = new ExamCliniqueDaoImpl();
			OrdonnanceDaoImpl daoImpl3 = new OrdonnanceDaoImpl();
			String sql = "SELECT * FROM consultation;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Consultation> consultations = new ArrayList<>();
			while(rs.next()) {
				Consultation consultation = new Consultation(
						rs.getInt("idConsultation"),
						rs.getInt("patientid"),
						daoImpl.findById(rs.getInt("rendezvousId")),
						rs.getString("titre"),
						daoImpl2.findByConsId(rs.getInt("idConsultation")),
						daoImpl3.findByConsId(rs.getInt("idConsultation"))
						);
				consultations.add(consultation);
			}
			return consultations;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Consultation t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Consultation t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
