package re.forestier.edu.rpg;

import java.util.HashMap;

public class Level {
	public HashMap<String,Integer> caracteristiques;
	public int numeroNiveau;
	
	public Level(int numeroNiveau) {
		this.caracteristiques = new HashMap<>();
		this.numeroNiveau = numeroNiveau;
	}
	
	public void AjouteNiveau(String s,int i) {
		caracteristiques.put(s, i);
	}

}
