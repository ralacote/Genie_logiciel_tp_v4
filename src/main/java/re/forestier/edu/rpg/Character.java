package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Character {
	public ArrayList<Level> levels;
	public CharacterType type;
	
	public Character(CharacterType type,ArrayList<Level> levels) {
		this.type = type;
		this.levels = levels;
	}
	
	public HashMap<String,Integer> trouveCaracteristique(int niveauRecherche){
		for(Level n : levels) {
			if(n.levelNumber == niveauRecherche) {
				return n.caracteristics;
			}
		}
		return new HashMap<String,Integer>();
	}

}
