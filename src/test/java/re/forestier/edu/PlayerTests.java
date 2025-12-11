package re.forestier.edu;

//import org.junit.Before;
import org.junit.jupiter.api.*;

import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.TypePersonnage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class PlayerTests {

	private Player p;
	
	@BeforeEach
	public void setUp() {
		p = new Player("Florian", "Grognak le barbare", TypePersonnage.ADVENTURER, 100, new ArrayList<>());		
	}
	
    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        assertThat(p.playerName, is("Florian"));
    }
    
    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        Player p = new Player("Florian", "Grognak le barbare", TypePersonnage.ADVENTURER, 100, new ArrayList<>());

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    @DisplayName("Impossible to have negative money V2")
    void testNegativeMoneyV2() {    	
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->p.removeMoney(200));
        assertEquals("Player can't have a negative money!", exception.getMessage());
    }

    @Test
    @DisplayName("Ajout de monnaie")
    void testAddMoney() {
        p.addMoney(50);
        assertEquals(p.money,150);
    }

    @Test
    @DisplayName("Ajout de monnaie négative")
    void testAddMoneyNegative() {
        p.addMoney(-50);
        assertEquals(p.money,50);
    }

    @Test
    @DisplayName("Retirer de l'argent")
    void testRemoveNegative() {
        p.removeMoney(50);
        assertEquals(p.money,50);
    }

    /*@Test
    @DisplayName("Impossible de créer un personnage avec une mauvaise classe")
    void testCreatePlayerBadClass() {
        Player p = new Player("Florian", "Grognak le barbare", RIDER, 100, new ArrayList<>());
        assertEquals(p.playerName,null);        
    }*/

    @Test
    @DisplayName("Récupération de la classe")
    void testGetClass() {
    	assertEquals(p.getAvatarClass(),TypePersonnage.ADVENTURER);        
    }

    @Test
    @DisplayName("Récupération de l'xp")
    void testGetXp() {
    	assertEquals(p.getXp(),0);        
    }

    @Test
    @DisplayName("Test de RetriveLevel lorsque xp = 0")
    void testRetriveLevel() {
    	assertEquals(p.retrieveLevel(),1);        
    }
    
    @Test
    @DisplayName("Test de RetriveLevel lorsque xp entre 27 et 57")
    void testRetriveLevel4() {
    	UpdatePlayer.addXp(p,42);
    	System.out.print(p.retrieveLevel());
    	assertEquals(p.retrieveLevel(),3);        
    }
    
    @Test
    @DisplayName("Test de RetriveLevel lorsque xp superieur à 111")
    void testRetriveLevel5() {
    	UpdatePlayer.addXp(p,666);
    	assertEquals(p.retrieveLevel(),5);        
    }


}
