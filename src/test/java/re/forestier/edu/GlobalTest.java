package re.forestier.edu;

import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.Affichage;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.TypePersonnage;

import java.util.ArrayList;

import static org.approvaltests.Approvals.verify;


public class GlobalTest {

    @Test
    void testAffichageBase() {
        Player player = new Player("Florian", "Gnognak le Barbare", TypePersonnage.ADVENTURER, 200, new ArrayList<>());
    	UpdatePlayer.addXp(player,20);
    	//player.retrieveLevel();

    	player.inventory = new ArrayList<>(java.util.Arrays.asList("Elendil"));

        verify(Affichage.afficherJoueur(player));
    }

}
