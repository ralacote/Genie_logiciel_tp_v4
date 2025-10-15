package re.forestier.edu.rpg;

public class Objet {
	private String nom;
	private String effet;
	
	public Objet(String nom,String effet) {
		this.nom = nom;
		this.effet = effet;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getEffet() {
		return this.effet;
	}

	
}
