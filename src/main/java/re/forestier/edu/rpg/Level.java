package re.forestier.edu.rpg;

import java.util.HashMap;

public class Level {
	public HashMap<String,Integer> caracteristics;
	public int levelNumber;
	
	public Level(int levelNumber) {
		this.caracteristics = new HashMap<>();
		this.levelNumber = levelNumber;
	}
	
	public void AjouteNiveau(String caracteristicName,int caracteristicNumber) {
		caracteristics.put(caracteristicName, caracteristicNumber);
	}

}
