package model;

/**
 * Created by TheDinoSLayer on 10/07/2016.
 */
public enum Nature {
    ADAMANT("Adamant"),
    BASHFUL("Bashful"),
    BOLD("Bold"),
    BRAVE("Brave"),
    CALM("Calme"),
    CAREFUL("Careful"),
    DOCILE("Docile"),
    GENTLE("Gentle"),
    HARDY("Hardy"),
    IMPISH("Impish"),
    JOLLY("Jolly"),
    LAX("Lax"),
    LONELY("Lonely"),
    MILD("Mild"),
    MODEST("Modest"),
    NAIVE("Naive"),
    NAUGHTY("Naughty"),
    QUIET("Quiet"),
    QUIRKY("Quirky"),
    RASH("Rash"),
    RELAXED("Relaxed"),
    SASSY("Sassy"),
    SERIOUS("Serious"),
    TIMID("Timid");

    private String display;

    Nature(String display) { this.display = display; }

    public String getDisplay() {return this.display; }
}
