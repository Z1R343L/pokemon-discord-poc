package fr.reminy.pokemon_discord.command;

public enum Category {
    COMMON("Misc. Commands"),
    GAME("Game Commands");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
