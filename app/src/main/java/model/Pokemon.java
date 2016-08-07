package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheDinoSlayer on 09/07/2016.
 */
public class Pokemon {
    private short id;
    private String name;
    private Types []type = new Types[2];
    private Nature nature;
    private byte level;

    private List<Ability> abilities;
    private List<Move> moves;

    private float height;
    private float weight;

    private byte friendship;

    private byte hp;
    private byte atk;
    private byte def;
    private byte spa;
    private byte spd;
    private byte spe;

    public Pokemon() {
        this.id = 0;
        this.name = "MissingNo";
        this.type[0] = Types.NORMAL;
        this.level = 0;
        this.height = 3.3f;
        this.weight = 1590.8f;
        this.friendship = 0;

        this.hp = 33;
        this.atk = 136 - 0xff;
        this.def = 0;
        this.spa = 6;
        this.spd = 6;
        this.spe = 29;

        this.abilities = new ArrayList<>();
        this.moves = new ArrayList<>();
    }

    //getter
    public short getId() { return this.id; }
    public String getName() { return this.name; }
    public Types[] getType() { return this.type; }
    public Nature getNature() { return this.nature; }
    public byte getLevel() { return this.level; }
    public List<Ability> getAbilities() { return this.abilities; }
    public List<Move> getMoveList() { return this.moves; }

    public float getHeight() { return this.height; }
    public float getWeight() { return this.weight; }

    public int getFriendship() {
        if(this.friendship >= 0) {
            return this.friendship;
        } else {
            return (this.friendship + 0xff);
        }
    }

    public int getHP() {
        if(this.hp >= 0) {
            return this.hp;
        } else {
            return (this.hp + 0xff);
        }
    }

    public int getAtk() {
        if(this.atk >= 0) {
            return this.atk;
        } else {
            return (this.atk + 0xff);
        }
    }

    public int getDef() {
        if(this.def >= 0) {
            return this.def;
        } else {
            return (this.def + 0xff);
        }
    }

    public int getSpA() {
        if(this.spa >= 0) {
            return this.spa;
        } else {
            return (this.spa + 0xff);
        }
    }

    public int getSpD() {
        if(this.spd >= 0) {
            return this.spd;
        } else {
            return (this.spd + 0xff);
        }
    }

    public int getSpe() {
        if(this.spe >= 0) {
            return this.spe;
        } else {
            return (this.spe + 0xff);
        }
    }

    //setter
    public void setId(short id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(Types[] type) { this.type = type; }
    public void setType(int i, Types type) { this.type[i] = type; }
    public void setNature(Nature nature) {this.nature = nature; }
    public void setLevel(byte level) { if(level >= 1 && level <= 100) this.level = level; }
    public void setAbilities(List<Ability> abilities) {this.abilities = abilities; }
    public void setMoveList(List<Move> moveList) { this.moves = moveList; }
    public void setHeight(float height) { this.height = height; }
    public void setWeight(float weight) { this.weight = weight; }

    public void setFriendship(int friendship) {
        if(friendship >= 0 && friendship <= 127) {
            this.friendship = (byte) friendship;
        } else if(friendship >= 128 && friendship <= 255) {
            this.friendship = (byte) (friendship - 0xff);
        }
    }

    public void setHP(int hp) {
        if(hp >= 0 && hp <= 127) {
            this.hp = (byte) hp;
        } else if(hp >= 128 && hp <= 255) {
            this.hp = (byte) (hp - 0xff);
        }
    }

    public void setAtk(int atk) {
        if(atk >= 0 && atk <= 127) {
            this.atk = (byte) atk;
        } else if(atk >= 128 && atk <= 255) {
            this.atk = (byte) (atk - 0xff);
        }
    }

    public void setDef(int def) {
        if(def >= 0 && def <= 127) {
            this.def = (byte) def;
        } else if(def >= 128 && def <= 255) {
            this.def = (byte) (def - 0xff);
        }
    }

    public void setSpA(int spa) {
        if(spa >= 0 && spa <= 127) {
            this.spa = (byte) spa;
        } else if(spa >= 128 && spa <= 255) {
            this.spa = (byte) (spa - 0xff);
        }
    }

    public void setSpD(int spd) {
        if(spd >= 0 && spd <= 127) {
            this.spd = (byte) spd;
        } else if(spd >= 128 && spd <= 255) {
            this.spd = (byte) (spd - 0xff);
        }
    }

    public void setSpe(int spe) {
        if(spe >= 0 && spe <= 127) {
            this.spe = (byte) spe;
        } else if(spe >= 128 && spe <= 255) {
            this.spe = (byte) (spe  - 0xff);
        }
    }
}
