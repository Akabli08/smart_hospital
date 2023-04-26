package entities;

import java.util.List;

public class Consultation {
	
	private int idConsultation;
	private int patientid;
	private RendezVous rendezvous;
	private String titre;
	private List<ExamenClinique> examenClinique;
	private List<Ordonnance> ordonnance;
	
	public Consultation() {
	}

	public Consultation(int idConsultation, int patientid, RendezVous rendezvous, String titre,
			List<ExamenClinique> examenClinique, List<Ordonnance> ordonnance) {
		this.idConsultation = idConsultation;
		this.patientid = patientid;
		this.rendezvous = rendezvous;
		this.titre = titre;
		this.examenClinique = examenClinique;
		this.ordonnance = ordonnance;
	}

	public int getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public RendezVous getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(RendezVous rendezvous) {
		this.rendezvous = rendezvous;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<ExamenClinique> getExamenClinique() {
		return examenClinique;
	}

	public void setExamenClinique(List<ExamenClinique> examenClinique) {
		this.examenClinique = examenClinique;
	}

	public List<Ordonnance> getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(List<Ordonnance> ordonnance) {
		this.ordonnance = ordonnance;
	}
	
}
