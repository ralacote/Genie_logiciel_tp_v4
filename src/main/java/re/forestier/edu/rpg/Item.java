package re.forestier.edu.rpg;

public class Item {
	private String name;
	private String effect;
	private float weight;
	private Integer value;

	
	public Item(String nom,String effet) {
		this.name = nom;
		this.effect = effet;
	}
	
	public Item(String nom,String effet,float weight,int value) {
		this(nom,effet);
		this.weight = weight;
		this.value = value;
	}

	
	public String getName() {
		return this.name;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public float getWeight() {
		return this.weight;
	}

	public int getValue() {
		return this.value;
	}


	
}
