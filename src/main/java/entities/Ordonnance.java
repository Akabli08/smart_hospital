package entities;

import java.util.ArrayList;

public class Ordonnance {
	
	private int idOrdonnance;
	private int consultationId;
	private ArrayList<Traitement> traitements;
	private String description;
	
	public Ordonnance() {
	}

	public Ordonnance(int idOrdonnance, int consultationId, ArrayList<Traitement> traitement, String description) {
		
		this.idOrdonnance = idOrdonnance;
		this.consultationId = consultationId;
		this.traitements = traitement;
		this.description = description;
	}
	
	public Ordonnance(int consultationId, Patient patient, ArrayList<Traitement> traitement, String description) {
		this.consultationId = consultationId;
		this.traitements = traitement;
		this.description = description;
	}

	public int getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(int idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public int getConsultation() {
		return consultationId;
	}

	public void setConsultation(int consultationId) {
		this.consultationId = consultationId;
	}

	public ArrayList<Traitement> getTraitements() {
		return traitements;
	}

	public void setTraitements(ArrayList<Traitement> traitement) {
		this.traitements = traitement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
