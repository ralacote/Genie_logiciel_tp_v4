package re.forestier.edu.rpg;

public class Item {
	private String name;
	private String effect;
	private float weight;
	private float value;

	
	public Item(String nom,String effet) {
		this.name = nom;
		this.effect = effet;
	}
	
	public Item(String nom,String effet,float weight,float value) {
		this(nom,effet);
		this.weight = weight;
		this.value = value;
	}

	
	public String getNom() {
		return this.name;
	}
	
	public String getEffet() {
		return this.effect;
	}
	
	public float getWeight() {
		return this.weight;
	}

	public float getValue() {
		return this.value;
	}


	
}
