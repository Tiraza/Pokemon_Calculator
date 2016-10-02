package model;

/**
 * Created by TheDinoSlayer on 27/08/2016.
 */
public enum Status {
    HEALTHY("Healthy"),
    POISONED("Poisoned"),
    BADLYPOISONED("Badly Poisoned"),
    BURNED("Burned"),
    PARALYZED("Paralyzed"),
    ASLEEP("Asleep"),
    FROZEN("Frozen");

    private String display;

    Status(String display) {this.display = display;}

    @Override public String toString() {return this.display;}
}
