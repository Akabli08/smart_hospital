package entities;


public class Traitement {
	
	private int idTraitement;
	private int ordonnanceId;
	private String medicament;
	private String quantite;
	private String duree_traitement;
	private String description;
	
	public Traitement() {
	}

	public Traitement(int idTraitement, int ordonnanceId, String medicament, String quantite, String duree_traitement,
			String description) {
		super();
		this.idTraitement = idTraitement;
		this.ordonnanceId = ordonnanceId;
		this.medicament = medicament;
		this.quantite = quantite;
		this.duree_traitement = duree_traitement;
		this.description = description;
	}
	
	public Traitement(int ordonnanceId, String medicament, String quantite, String duree_traitement,
			String description) {
		super();
		this.ordonnanceId = ordonnanceId;
		this.medicament = medicament;
		this.quantite = quantite;
		this.duree_traitement = duree_traitement;
		this.description = description;
	}

	public int getIdTraitement() {
		return idTraitement;
	}

	public void setIdTraitement(int idTraitement) {
		this.idTraitement = idTraitement;
	}

	public String getMedicament() {
		return medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrdonnanceId() {
		return ordonnanceId;
	}

	public void setOrdonnanceId(int ordonnanceId) {
		this.ordonnanceId = ordonnanceId;
	}

	public String getDuree_traitement() {
		return duree_traitement;
	}

	public void setDuree_traitement(String duree_traitement) {
		this.duree_traitement = duree_traitement;
	}
	
	
	
	
	
}
