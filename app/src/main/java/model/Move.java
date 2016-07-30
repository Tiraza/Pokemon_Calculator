package model;

/**
 * Created by TheDinoSlayer on 10/07/2016.
 */
public class Move {
    //Attributes
    private short id;
    private String name;
    private Types type;
    private Byte power;
    private Category category;

    //Constructor
    public Move() {
        this.id = 0;
        this.name = "<No Move>";
        this.type = Types.NORMAL;
        this.power = 0;
        this.category = Category.PHYSICAL;
    }

    public Move(short id, String name, Types type, Byte power, Category category) {
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
    public Category getCategory() { return category; }
    public int getPower() {
        if(this.power >= 0 && this.power <= 127) {
            return this.power;
        } else {
            return (this.power + 0xff);
        }
    }

    //Setter
    public void setId(short id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(Types type) { this.type = type; }
    public void setCategory(Category category) { this.category = category; }
    public void setPower(int power) {
        if(power >= 0 && power <= 127) {
            this.power = (byte) power;
        } else if(power >= 128 && power <= 255) {
            this.power = (byte) (power - 0xff);
        }
    }
}
