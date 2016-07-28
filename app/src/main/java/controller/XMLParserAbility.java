package controller;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.Ability;

/**
 * Created by TheDinoSlayer on 15/07/2016.
 */
public class XMLParserAbility {
    private List<Ability> abilities;
    private Ability ability;
    private XmlPullParser parser;

    public XMLParserAbility(InputStream is) throws XmlPullParserException, IOException {
            this.abilities = new ArrayList<>();
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            this.parser =  xmlFactoryObject.newPullParser();
            this.parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            this.parser.setInput(is, null);
    }

    public void parseXML(short[] id) throws XmlPullParserException, IOException {
        int event = this.parser.getEventType();

        while (event != XmlPullParser.END_DOCUMENT) {
            String name = this.parser.getName();

            switch (event) {
                case XmlPullParser.START_TAG:
                    if(name.equals("ability")) {
                        this.ability = new Ability();
                        short tempID = Short.parseShort(this.parser.getAttributeValue(null, "id"));
                        boolean contain = false;
                        for(short i: id) {
                            if(i == tempID) {
                                contain = true;
                                break;
                            }
                        }
                        if(contain) {
                            this.ability.setId(tempID);
                        } else {
                            this.ability = null;
                            break;
                        }
                    } else if (this.ability != null) {
                        if(name.equals("name")) {
                            this.ability.setName(this.parser.nextText());
                        } else if(name.equals("effect")) {
                            this.ability.setEffect(this.parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = this.parser.getName();
                    if(name.equalsIgnoreCase("ability") && this.ability != null) {
                        this.abilities.add(ability);
                    }
                    break;
            }
            event = this.parser.next();
        }
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}
