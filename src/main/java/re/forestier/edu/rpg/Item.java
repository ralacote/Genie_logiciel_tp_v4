package re.forestier.edu.rpg;

public class Item {
	private String nom;
	private String effet;
	
	public Item(String nom,String effet) {
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
