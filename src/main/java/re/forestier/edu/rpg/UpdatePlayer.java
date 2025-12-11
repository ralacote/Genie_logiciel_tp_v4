package re.forestier.edu.rpg;

import java.util.HashMap;
import java.util.Random;

public class UpdatePlayer {
    
    private final static Item[] objectList = {
    		new Item("Lookout Ring","Prevents surprise attacks"),
    		new Item("Scroll of Stupidity","INT-2 when applied to an enemy"),
    		new Item("Draupnir","Increases XP gained by 100%"),
    		new Item("Magic Charm","Magic +10 for 5 rounds"),
    		new Item("Rune Staff of Curse,","May burn your ennemies... Or yourself. Who knows?"),
    		new Item("Combat Edge","Well, that's an edge"),
    		new Item("Holy Elixir","Recover your HP")
    };

    public static boolean addXp(Player player, int xp) {

        if (xp != 0) {
            player.xp += xp;
            Random random = new Random();
            player.inventory.add(objectList[random.nextInt(objectList.length)].getNom());
            PersonnagesAbilites p = new PersonnagesAbilites();
            HashMap<String, Integer> abilities = p.trouveCaracteristique(player.getAvatarClass(),player.retrieveLevel());
            
            abilities.forEach((ability, level) -> {
                player.abilities.put(ability, abilities.get(ability));
            });
            return true;
        }
        return false;
    }

    public static void majPdvFinTour(Player player) {
        if(player.currentHealthPoints == 0) {
            System.out.println("Le joueur est KO !");
            return;
        }
        
        if(player.currentHealthPoints >= player.healthPoints/2){
        	player.currentHealthPoints = player.healthPoints;
            return;
        }
        else {
        	switch(player.getAvatarClass()) {
        		case ADVENTURER:
                    player.currentHealthPoints += 1;
                    if (player.retrieveLevel() >= 3) {
                        player.currentHealthPoints += 1;
                    }
                    return;
        		case DWARF:
                    player.currentHealthPoints += 1;
                	if(player.inventory.contains("Holy Elixir")) {
                		player.currentHealthPoints += 1;
                    }
                    return;
        		case ARCHER:
                	player.currentHealthPoints += 1 ;
                	if(player.inventory.contains("Magic Bow")) {
                		player.currentHealthPoints += player.currentHealthPoints/8-1;
                    }
                	return;
        	}

        } 
    }
}