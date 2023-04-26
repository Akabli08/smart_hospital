package entities;

import java.sql.Date;

public class ExamenClinique {
	
	private int idExamenClinique;
	private int patientId;
	private Date dateExamenClinique;
	private int poid;
	private int hauteur;
	private int temperature;
	private int pression;
	private String description;
	
	public ExamenClinique() {
	}
	
	public ExamenClinique(int idExamenClinique, int patientId, int poid,
			int hauteur, int temperature, int pression, String description, Date dateExamenClinique) {
		super();
		this.idExamenClinique = idExamenClinique;
		this.patientId = patientId;
		this.dateExamenClinique = dateExamenClinique;
		this.poid = poid;
		this.hauteur = hauteur;
		this.temperature = temperature;
		this.pression = pression;
		this.description = description;
	}
	
	public ExamenClinique(int patientId, int poid,
			int hauteur, int temperature, int pression, String description, Date dateExamenClinique) {
		super();
		this.patientId = patientId;
		this.dateExamenClinique = dateExamenClinique;
		this.poid = poid;
		this.hauteur = hauteur;
		this.temperature = temperature;
		this.pression = pression;
		this.description = description;
	}
	public int getIdExamenClinique() {
		return idExamenClinique;
	}
	public void setIdExamenClinique(int idExamenClinique) {
		this.idExamenClinique = idExamenClinique;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public Date getDateExamenClinique() {
		return dateExamenClinique;
	}
	public void setDateExamenClinique(Date dateExamenClinique) {
		this.dateExamenClinique = dateExamenClinique;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getPression() {
		return pression;
	}
	public void setPression(int pression) {
		this.pression = pression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
}
