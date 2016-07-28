package controller;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.Attack;
import model.Category;
import model.Types;

/**
 * Created by TheDinoSlayer on 28/07/2016.
 */
public class XMLParserAttack {
    private List<Attack> attacks;
    private Attack attack;
    private XmlPullParser parser;

    public XMLParserAttack(InputStream is) throws XmlPullParserException, IOException {
        this.attacks = new ArrayList<>();
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        this.parser = xmlPullParserFactory.newPullParser();
        this.parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        this.parser.setInput(is, null);
    }

    public void parseXML() throws XmlPullParserException, IOException {
        int event = this.parser.getEventType();

        while (event != XmlPullParser.END_DOCUMENT) {
            String name = this.parser.getName();

            switch (event) {
                case XmlPullParser.START_TAG:
                    if (name.equals("attack")) {
                        this.attack = new Attack();
                        this.attack.setId(Short.parseShort(this.parser.getAttributeValue(null, "id")));
                    } else if(this.attack != null) {
                        if(name.equals("name")) {
                            this.attack.setName(this.parser.nextText());
                        } else if(name.equals("type")) {
                            this.parseType(this.parser.nextText());
                        } else if(name.equals("power")) {
                            this.attack.setPower(Integer.parseInt(this.parser.getAttributeValue(null, "value")));
                        } else if(name.equals("category")) {
                            this.parseCategory(this.parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = this.parser.getName();
                    if(name.equalsIgnoreCase("attack") && this.attack != null) {
                        this.attacks.add(this.attack);
                    }
                    break;
            }
            event = this.parser.next();
        }
    }

    private void parseType(String type) {
        switch (type) {
            case "Normal": this.attack.setType(Types.NORMAL); break;
            case "Fight": this.attack.setType(Types.FIGHT); break;
            case "Flying": this.attack.setType(Types.FLYING); break;
            case "Poison": this.attack.setType(Types.POISON); break;
            case "Ground": this.attack.setType(Types.GROUND); break;
            case "Rock": this.attack.setType(Types.ROCK); break;
            case "Bug": this.attack.setType(Types.BUG); break;
            case "Ghost": this.attack.setType(Types.GHOST); break;
            case "Steel": this.attack.setType(Types.STEEL); break;
            case "Fire": this.attack.setType(Types.FIRE); break;
            case "Water": this.attack.setType(Types.WATER); break;
            case "Grass": this.attack.setType(Types.GRASS); break;
            case "Electric": this.attack.setType(Types.ELECTR); break;
            case "Psychic": this.attack.setType(Types.PSYCHIC); break;
            case "Ice": this.attack.setType(Types.ICE); break;
            case "Dragon": this.attack.setType(Types.DRAGON); break;
            case "Dark": this.attack.setType(Types.DARK); break;
            case "Fairy": this.attack.setType(Types.FAIRY); break;
            default: break;
        }
    }

    private void parseCategory(String category) {
        switch (category) {
            case "Physical": this.attack.setCategory(Category.PHYSICAL); break;
            case "Special": this.attack.setCategory(Category.SPECIAL); break;
            case "Status": this.attack.setCategory(Category.STATUS); break;
            default: break;
        }
    }

    public List<Attack> getAttacks() {
        return attacks;
    }
}
