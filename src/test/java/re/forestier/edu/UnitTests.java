package re.forestier.edu;

//import org.junit.Before;
import org.junit.jupiter.api.*;

import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.player;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class UnitTests {
	
	private player p;
	
	@BeforeEach
	public void setUp() {
		p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());		
	}
	
    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        //player = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
        assertThat(p.playerName, is("Florian"));
    }

    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        player p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());

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

    @Test
    @DisplayName("Impossible de créer un personnage avec une mauvaise classe")
    void testCreatePlayerBadClass() {
        player p = new player("Florian", "Grognak le barbare", "RIDER", 100, new ArrayList<>());
        assertEquals(p.playerName,null);        
    }

    @Test
    @DisplayName("Récupération de la classe")
    void testGetClass() {
    	assertEquals(p.getAvatarClass(),"ADVENTURER");        
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
    	UpdatePlayer up = new UpdatePlayer();
    	up.addXp(p,42);
    	assertEquals(p.retrieveLevel(),3);        
    }
    
    @Test
    @DisplayName("Test de RetriveLevel lorsque xp superieur à 111")
    void testRetriveLevel5() {
    	UpdatePlayer up = new UpdatePlayer();
    	up.addXp(p,666);
    	assertEquals(p.retrieveLevel(),5);        
    }


    @Test
    @DisplayName("Test d'ajout Xp")
    void testAddXp() {
    	UpdatePlayer up = new UpdatePlayer();
    	up.addXp(p,20);
    	assertEquals(p.getXp(),20);
    }

    @Test
    @DisplayName("Test d'ajout Xp possible")
    void testAddXpTrue() {
    	UpdatePlayer up = new UpdatePlayer();
    	up.addXp(p,20);
    	assertEquals(up.addXp(p,40),true);
    }

    @Test
    @DisplayName("Test d'ajout Xp impossible")
    void testAddXpFalse() {
    	UpdatePlayer up = new UpdatePlayer();
    	up.addXp(p,20);
    	assertEquals(up.addXp(p,0),false);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour dwarf et holy elixir")
    void testFinTourDwarfHolyElixir() {
		player pl = new player("Florian", "Grognak le barbare", "DWARF", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 10;
    	pl.healthpoints = 40;
    	pl.inventory.add("Holy Elixir");
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,12);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour dwarf sans holy elixir")
    void testFinTourDwarf() {
		player pl = new player("Florian", "Grognak le barbare", "DWARF", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 10;
    	pl.healthpoints = 40;
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,11);
    }

    
    @Test
    @DisplayName("Test de maj de Fin de tour pour adventurer")
    void testFinTourAdventurer() {
		player pl = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 10;
    	pl.healthpoints = 40;
    	pl.inventory.add("Holy Elixir");
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour arcer avec arc magique")
    void testFinTourArcherMagicBow() {
		player pl = new player("Florian", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 10;
    	pl.healthpoints = 40;
    	pl.inventory.add("Magic Bow");
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour archer sans arc magique")
    void testFinTourArcher() {
		player pl = new player("Florian", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 10;
    	pl.healthpoints = 40;
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour rétablir currenthealthpoints")
    void testFinTourTooManyHealth() {
		player pl = new player("Florian", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 15;
    	pl.healthpoints = 10;
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,10);
    }    

    
    @Test
    @DisplayName("Test de maj de Fin de tour lorsque vie == 0")
    void testFinTourHealth0() {
    	UpdatePlayer up = new UpdatePlayer();
    	p.currenthealthpoints = 0;
    	up.majFinDeTour(p);
    	assertEquals(p.currenthealthpoints,0);
    }


}