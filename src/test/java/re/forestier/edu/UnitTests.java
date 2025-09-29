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
		player pl = new player("Florian", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());		
    	UpdatePlayer up = new UpdatePlayer();
    	pl.currenthealthpoints = 0;
    	up.majFinDeTour(pl);
    	assertEquals(pl.currenthealthpoints,0);
    }


}