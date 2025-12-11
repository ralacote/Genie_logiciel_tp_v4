package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    public String playerName;
    public String avatarName;
    private TypePersonnage avatarClass;

    public Integer money;

    public int level;
    public int healthPoints;
    public int currentHealthPoints;
    protected int xp;

    public HashMap<String, Integer> abilities;
    public ArrayList<String> inventory;
    
    public Player(String playerName, String avatarName, TypePersonnage avatarClass, int money, ArrayList<String> inventory) {
    	this.playerName = playerName;
        this.avatarName = avatarName;
        this.avatarClass = avatarClass;
        this.money = money;
        this.inventory = inventory;
        PersonnagesAbilites p = new PersonnagesAbilites();
        this.abilities = p.trouveCaracteristique(avatarClass,1);
    }
    
    public int getXp() {
        return this.xp;
    }

    public TypePersonnage getAvatarClass () {
        return avatarClass;
    }

    public void removeMoney(int amount) throws IllegalArgumentException {
        if (money - amount < 0) {
            throw new IllegalArgumentException("Player can't have a negative money!");
        }
        money -= amount;
    }
    public void addMoney(int amount) {
        money += amount;
    }
    
    private HashMap<Integer,Integer> calculateLevel(int nbLevel) {
        HashMap<Integer, Integer> levels = new HashMap<>();
        
        int result = 0;
        for (int i = 2; i <= nbLevel; i++) {
        	result = (i-1)*10+((i*result)/4);
            levels.put(i,result);   
        }
        return levels;
    }
    
    public int retrieveLevel() {
    	
    	int levelMax = 5;
        HashMap<Integer, Integer> levels = calculateLevel(levelMax);
        
        for(int i=2; i < levelMax; i++) {
        	if (xp< levels.get(i)) {
        		return i-1;
        	}
        }
        return levelMax;
    }

}