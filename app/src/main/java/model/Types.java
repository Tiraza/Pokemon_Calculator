package model;

/**
 * Created by TheDinoSlayer on 10/07/2016.
 */
public enum Types {
    NORMAL("Normal"),
    FIGHT("Fighting"),
    FLYING("Flying"),
    POISON("Poison"),
    GROUND("Ground"),
    ROCK("Rock"),
    BUG("Bug"),
    GHOST("Ghost"),
    STEEL("Steel"),
    FIRE("Fire"),
    WATER("Water"),
    GRASS("Grass"),
    ELECTR("Electric"),
    PSYCHIC("Psychic"),
    ICE("Ice"),
    DRAGON("Dragon"),
    DARK("Dark"),
    FAIRY("Fairy"),
    UKNOWN("");

    private String display;

    Types(String display) { this.display = display; }

    public String getDisplay() { return this.display; }
}
