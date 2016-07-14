package model;

/**
 * Created by TheDinoSlayer on 10/07/2016.
 */
public class Attack {
    //Attributes
    private short id;
    private String name;
    private Types type;
    private Byte power;
    private Boolean category;

    //Constructor
    public Attack() {
        this.id = 0;
        this.name = "<No Move>";
        this.type = Types.NORMAL;
        this.power = 0;
        this.category = false;
    }

    public Attack(short id, String name, Types type, Byte power, Boolean category) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.power = power;
        this.category = category;
    }

    //Getter
    public short getId() { return id; }
    public String getName() { return this.name; }
    public Types getType() { return type; }
    public Byte getPower() { return power; }
    public Boolean getCategory() { return category; }

    //Setter
    public void setId(short id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(Types type) { this.type = type; }
    public void setPower(Byte power) { this.power = power; }
    public void setCategory(Boolean category) { this.category = category; }
}
