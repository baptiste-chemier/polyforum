package application.polyforum.model;

public class Etudiant {
	
	private Long etudiantId;
	private String nom;
	private String prenom;
	private String email;
	
	public final Long getEtudiantId() {
		return etudiantId;
	}
	public final void setEtudiantId(Long etudiantId) {
		this.etudiantId = etudiantId;
	}
	public final String getNom() {
		return nom;
	}
	public final void setNom(String nom) {
		this.nom = nom;
	}
	public final String getPrenom() {
		return prenom;
	}
	public final void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	
	
}
