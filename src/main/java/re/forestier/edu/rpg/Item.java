package re.forestier.edu.rpg;

public class Item {
	private String nom;
	private String effet;
	private float weight;
	private float value;

	
	public Item(String nom,String effet) {
		this.nom = nom;
		this.effet = effet;
	}
	
	public Item(String nom,String effet,float weight,float value) {
		this(nom,effet);
		this.weight = weight;
		this.value = value;
	}

	
	public String getNom() {
		return this.nom;
	}
	
	public String getEffet() {
		return this.effet;
	}
	
	public float getWeight() {
		return this.weight;
	}

	public float getValue() {
		return this.value;
	}


	
}
