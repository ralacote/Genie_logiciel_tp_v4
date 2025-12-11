package re.forestier.edu;

//import org.junit.Before;
import org.junit.jupiter.api.*;

import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.Item;
import re.forestier.edu.rpg.TypePersonnage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class UpdatePLayerTests {
	
	private Player p;
	
	@BeforeEach
	public void setUp() {
		p = new Player("Florian", "Grognak le barbare", TypePersonnage.ADVENTURER, 100, new ArrayList<>());		
	}
	
    @Test
    @DisplayName("Test d'ajout Xp")
    void testAddXp() {
    	UpdatePlayer.addXp(p,20);
    	assertEquals(p.getXp(),20);
    }

    @Test
    @DisplayName("Test d'ajout Xp possible")
    void testAddXpTrue() {
    	UpdatePlayer.addXp(p,20);
    	assertEquals(UpdatePlayer.addXp(p,40),true);
    }

    @Test
    @DisplayName("Test d'ajout Xp impossible")
    void testAddXpFalse() {
    	UpdatePlayer.addXp(p,20);
    	assertEquals(UpdatePlayer.addXp(p,0),false);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour dwarf et holy elixir")
    void testFinTourDwarfHolyElixir() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.DWARF, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 10;
    	pl.healthPoints = 40;
    	pl.inventory.add(new Item("Holy Elixir","A"));
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(pl.currentHealthPoints,12);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour dwarf sans holy elixir")
    void testFinTourDwarf() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.DWARF, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 10;
    	pl.healthPoints = 40;
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(pl.currentHealthPoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour adventurer")
    void testFinTourAdventurer() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.ADVENTURER, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 10;
    	pl.healthPoints = 40;
    	pl.inventory.add(new Item("Holy Elixir","A"));
    	UpdatePlayer.majPdvFinTour(pl);
    	System.out.print(pl.currentHealthPoints);
    	assertEquals(pl.currentHealthPoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour arcer avec arc magique")
    void testFinTourArcherMagicBow() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.ARCHER, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 10;
    	pl.healthPoints = 40;
    	pl.inventory.add(new Item("Magic Bow","A"));
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(pl.currentHealthPoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour archer sans arc magique")
    void testFinTourArcher() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.ARCHER, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 10;
    	pl.healthPoints = 40;
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(pl.currentHealthPoints,11);
    }
    
    @Test
    @DisplayName("Test de maj de Fin de tour pour rétablir currenthealthpoints")
    void testFinTourTooManyHealth() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.ARCHER, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 15;
    	pl.healthPoints = 10;
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(pl.currentHealthPoints,10);
    }    

    
    @Test
    @DisplayName("Test de maj de Fin de tour lorsque vie == 0")
    void testFinTourHealth0() {
		Player pl = new Player("Florian", "Grognak le barbare", TypePersonnage.ARCHER, 100, new ArrayList<>());		
    	pl.currentHealthPoints = 0;
    	UpdatePlayer.majPdvFinTour(pl);
    	assertEquals(0,pl.currentHealthPoints);
    }


}