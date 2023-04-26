package entities;

import java.sql.Date;

public class Patient {
	
	private int idPatient;
	private String nom;
	private String prenom;
	private String sexe;
	private Date dateNaissance;
	private String email;
	private String telephone;
	private String etatCevil;
	private String proffesion;
	private String adresse;
	private String ville;
	private String groupeSanguin;
	
	public Patient() {
	}

	public Patient(int idPatient, String nom, String prenom, String sexe, Date dateNaissance, String email,
			String telephone, String etatCevil, String proffesion, String adresse, String ville,
			String groupeSanguin) {
		super();
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.telephone = telephone;
		this.etatCevil = etatCevil;
		this.proffesion = proffesion;
		this.adresse = adresse;
		this.ville = ville;
		this.groupeSanguin = groupeSanguin;
	}

	public Patient(String nom, String prenom, String sexe, Date dateNaissance, String email, String telephone,
			String etatCevil, String proffesion, String adresse, String ville, String groupeSanguin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.telephone = telephone;
		this.etatCevil = etatCevil;
		this.proffesion = proffesion;
		this.adresse = adresse;
		this.ville = ville;
		this.groupeSanguin = groupeSanguin;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEtatCevil() {
		return etatCevil;
	}

	public void setEtatCevil(String etatCevil) {
		this.etatCevil = etatCevil;
	}

	public String getProffesion() {
		return proffesion;
	}

	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}
}
