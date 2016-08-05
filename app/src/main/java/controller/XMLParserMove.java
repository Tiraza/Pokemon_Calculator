package controller;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.Move;
import model.Category;
import model.Types;

/**
 * Created by TheDinoSlayer on 28/07/2016.
 */
public class XMLParserMove {
    private List<Move> moves;
    private Move move;
    private XmlPullParser parser;

    public XMLParserMove(InputStream is) throws XmlPullParserException, IOException {
        this.moves = new ArrayList<>();
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        this.parser = xmlPullParserFactory.newPullParser();
        this.parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        this.parser.setInput(is, null);
    }

    public void parseXML(short[] id) throws XmlPullParserException, IOException {
        int event = this.parser.getEventType();

        while (event != XmlPullParser.END_DOCUMENT) {
            String name = this.parser.getName();

            switch (event) {
                case XmlPullParser.START_TAG:
                    if (name.equals("move")) {
                        this.move = new Move();
                        short tempID = Short.parseShort(this.parser.getAttributeValue(null, "id"));
                        boolean contain = false;
                        for(short i:id) {
                            if(i == tempID) {
                                contain = true;
                                break;
                            }
                        }
                        if(contain) {
                            this.move.setId(tempID);
                        } else {
                            this.move = null;
                            break;
                        }
                    } else if(this.move != null) {
                        if(name.equals("name")) {
                            this.move.setName(this.parser.nextText());
                        } else if(name.equals("type")) {
                            this.parseType(this.parser.nextText());
                        } else if(name.equals("power")) {
                            this.move.setPower(Integer.parseInt(this.parser.getAttributeValue(null, "value")));
                        } else if(name.equals("category")) {
                            this.parseCategory(this.parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = this.parser.getName();
                    if(name.equalsIgnoreCase("move") && this.move != null) {
                        this.moves.add(this.move);
                    }
                    break;
            }
            event = this.parser.next();
        }
    }

    private void parseType(String type) {
        switch (type) {
            case "Normal": this.move.setType(Types.NORMAL); break;
            case "Fighting": this.move.setType(Types.FIGHT); break;
            case "Flying": this.move.setType(Types.FLYING); break;
            case "Poison": this.move.setType(Types.POISON); break;
            case "Ground": this.move.setType(Types.GROUND); break;
            case "Rock": this.move.setType(Types.ROCK); break;
            case "Bug": this.move.setType(Types.BUG); break;
            case "Ghost": this.move.setType(Types.GHOST); break;
            case "Steel": this.move.setType(Types.STEEL); break;
            case "Fire": this.move.setType(Types.FIRE); break;
            case "Water": this.move.setType(Types.WATER); break;
            case "Grass": this.move.setType(Types.GRASS); break;
            case "Electric": this.move.setType(Types.ELECTR); break;
            case "Psychic": this.move.setType(Types.PSYCHIC); break;
            case "Ice": this.move.setType(Types.ICE); break;
            case "Dragon": this.move.setType(Types.DRAGON); break;
            case "Dark": this.move.setType(Types.DARK); break;
            case "Fairy": this.move.setType(Types.FAIRY); break;
            default: break;
        }
    }

    private void parseCategory(String category) {
        switch (category) {
            case "Physical": this.move.setCategory(Category.PHYSICAL); break;
            case "Special": this.move.setCategory(Category.SPECIAL); break;
            case "Status": this.move.setCategory(Category.STATUS); break;
            default: break;
        }
    }

    public List<Move> getMoves() {
        return moves;
    }
}
