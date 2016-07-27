package model;

/**
 * Created by TheDinoSlayer on 11/07/2016.
 */
public class Ability {
    //Attributes
    private short id;
    private String name;
    private String effect;

    //Constructor
    public Ability() {
        this.id = 0;
        this.name = "Cacophony";
        this.effect = "Avoids sound-based moves.";
    }

    public Ability(short id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    //Getter
    public short getId() { return id; }
    public String getName() { return name; }
    public String getEffect() { return effect; }

    //Setter
    public void setId(short id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEffect(String effect) { this.effect = effect; }
}
