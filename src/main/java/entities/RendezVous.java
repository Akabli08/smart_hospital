package entities;

import java.sql.Date;

public class RendezVous {
	
	private int idRendezVous;;
	private Patient patient;
	private Utilisateur medecin;
	private String statut;
	private Date dateRendezVous;
	
	
	public RendezVous() {
	}

	public RendezVous(int idRendezVous, Patient patient, Utilisateur medecin, String statut, Date dateRendezVous) {
		this.idRendezVous = idRendezVous;
		this.patient = patient;
		this.medecin = medecin;
		this.statut = statut;
		this.dateRendezVous = dateRendezVous;
	}
	
	public RendezVous(Patient patient, Utilisateur medecin, String statut, Date dateRendezVous) {
		this.patient = patient;
		this.medecin = medecin;
		this.statut = statut;
		this.dateRendezVous = dateRendezVous;
	}

	public int getIdRendezVous() {
		return idRendezVous;
	}

	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Utilisateur getMedecin() {
		return medecin;
	}

	public void setMedecin(Utilisateur medecin) {
		this.medecin = medecin;
	}

	public Date getDateRendezVous() {
		return dateRendezVous;
	}

	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
