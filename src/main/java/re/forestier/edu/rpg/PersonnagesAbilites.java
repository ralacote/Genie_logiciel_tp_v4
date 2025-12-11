package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PersonnagesAbilites {
	public ArrayList<Personnage> lesPersonnages;
	
	public PersonnagesAbilites() {
        Level n1 = new Level(1);
        n1.AjouteNiveau("INT", 1);
        n1.AjouteNiveau("DEF", 1);
        n1.AjouteNiveau("ATK", 3);
        n1.AjouteNiveau("CHA", 2);
        
        Level n2 = new Level(2);
        n2.AjouteNiveau("INT", 2);
        n2.AjouteNiveau("CHA", 3);

        Level n3 = new Level(3);
        n3.AjouteNiveau("ATK", 5);
        n3.AjouteNiveau("ALC", 1);

        Level n4 = new Level(4);
        n4.AjouteNiveau("DEF", 3);

        Level n5 = new Level(5);
        n5.AjouteNiveau("VIS", 1);
        n5.AjouteNiveau("DEF", 4);
        
        Personnage adventurer = new Personnage(TypePersonnage.ADVENTURER, new ArrayList<Level>(Arrays.asList(n1,n2,n3,n4,n5)));
        
        Level r1 = new Level(1);
        r1.AjouteNiveau("INT", 1);
        r1.AjouteNiveau("ATK", 3);
        r1.AjouteNiveau("CHA", 1);
        r1.AjouteNiveau("VIS", 3);
        
        Level r2 = new Level(2);
        r2.AjouteNiveau("DEF", 1);
        r2.AjouteNiveau("CHA", 2);

        Level r3 = new Level(3);
        r3.AjouteNiveau("ATK", 3);

        Level r4 = new Level(4);
        r4.AjouteNiveau("DEF", 2);

        Level r5 = new Level(5);
        r5.AjouteNiveau("ATK", 4);

        Personnage archer = new Personnage(TypePersonnage.ARCHER, new ArrayList<Level>(Arrays.asList(r1,r2,r3,r4,r5)));

        Level d1 = new Level(1);
        d1.AjouteNiveau("ALC", 4);
        d1.AjouteNiveau("INT", 1);
        d1.AjouteNiveau("ATK", 3);
        
        Level d2 = new Level(2);
        d2.AjouteNiveau("DEF", 1);
        d2.AjouteNiveau("ALC", 5);

        Level d3 = new Level(3);
        d3.AjouteNiveau("ATK", 4);

        Level d4 = new Level(4);
        d4.AjouteNiveau("DEF", 2);

        Level d5 = new Level(5);
        d5.AjouteNiveau("CHA", 1);

        Personnage dwarf = new Personnage(TypePersonnage.DWARF, new ArrayList<Level>(Arrays.asList(d1,d2,d3,d4,d5)));
        
        Level g1 = new Level(1);
        g1.AjouteNiveau("ALC", 1);
        g1.AjouteNiveau("INT", 2);
        g1.AjouteNiveau("ATK", 2);
        
        Level g2 = new Level(2);
        g2.AjouteNiveau("ATK", 3);
        g2.AjouteNiveau("ALC", 4);

        Level g3 = new Level(3);
        g3.AjouteNiveau("VIS", 1);

        Level g4 = new Level(4);
        g4.AjouteNiveau("DEF", 1);

        Level g5 = new Level(5);
        g5.AjouteNiveau("DEF", 2);
        g5.AjouteNiveau("ATK", 4);

        Personnage goblin = new Personnage(TypePersonnage.GOBLIN, new ArrayList<Level>(Arrays.asList(g1,g2,g3,g4,g5)));

        
        lesPersonnages = new ArrayList<>(Arrays.asList(adventurer,archer,dwarf,goblin));
	}
	
	public HashMap<String, Integer> trouveCaracteristique(TypePersonnage type,int level) {
		
		for (Personnage p : lesPersonnages) {
			if(p.type == type) {
				return p.trouveCaracteristique(level);
			}
		}
		return new HashMap<String,Integer>();
	}
}
