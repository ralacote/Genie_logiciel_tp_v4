package re.forestier.edu;

import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.Affichage;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.Item;

import re.forestier.edu.rpg.TypePersonnage;

import java.util.ArrayList;

import static org.approvaltests.Approvals.verify;


public class GlobalTest {

    @Test
    void testAffichageBase() {
        Player player = new Player("Florian", "Gnognak le Barbare", TypePersonnage.ADVENTURER, 200, new ArrayList<>());
    	UpdatePlayer.addXp(player,20);
    	//player.retrieveLevel();
    	Item i = new Item("Elendil","Et Paf");
    	

    	player.inventory = new ArrayList<>();
    	player.inventory.add(i);

        verify(Affichage.afficherJoueur(player));
    }

}
