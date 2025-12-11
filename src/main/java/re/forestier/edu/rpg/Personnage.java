package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Personnage {
	public ArrayList<Level> niveaux;
	public TypePersonnage type;
	
	public Personnage(TypePersonnage type,ArrayList<Level> niveaux) {
		this.type = type;
		this.niveaux = niveaux;
	}
	
	public HashMap<String,Integer> trouveCaracteristique(int niveauRecherche){
		for(Level n : niveaux) {
			if(n.numeroNiveau == niveauRecherche) {
				return n.caracteristiques;
			}
		}
		return new HashMap<String,Integer>();
	}

}
