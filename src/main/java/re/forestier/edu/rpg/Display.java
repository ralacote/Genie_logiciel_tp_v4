package re.forestier.edu.rpg;

public class Display {

    public static String displayPlayerBasic(Player player) {
        final String[] finalString = {"Joueur " + player.avatarName + " joué par " + player.playerName};
        finalString[0] += "\nNiveau : " + player.retrieveLevel() + " (XP totale : " + player.xp + ")";
        finalString[0] += "\n\nCapacités :";
        player.abilities.forEach((name, level) -> {
            finalString[0] += "\n   " + name + " : " + level;
        });
        finalString[0] += "\n\nInventaire :";
        player.inventory.forEach(item -> {
            finalString[0] += "\n   " + item.getName();
        });

        return finalString[0];
    }

	public static String displayPlayerMarkdown(Player player) {
        final String[] finalString = {"# Joueur " + player.avatarName + " joué par " + player.playerName};
        finalString[0] += "\nNiveau : " + player.retrieveLevel() + " *(XP totale : " + player.xp + ")*";
        finalString[0] += "\n\n## Capacités :";
        player.abilities.forEach((name, level) -> {
            finalString[0] += "\n* " + name + " : " + level;
        });
        finalString[0] += "\n\n## Inventaire :";
        player.inventory.forEach(item -> {
            finalString[0] += "\n* " + item.getName();
        });
    
        return finalString[0];

	}
}
