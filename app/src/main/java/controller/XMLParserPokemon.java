package controller;

import android.content.Context;
import android.content.res.AssetManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.Pokemon;
import model.Types;

/**
 * Created by regedit on 06/08/2016.
 */
public class XMLParserPokemon {
    private List<Pokemon> pokemons;
    private Pokemon pokemon;
    private XmlPullParser parser;
    private AssetManager manager;

    public XMLParserPokemon(InputStream is, Context context) throws XmlPullParserException, IOException {
        this.pokemons = new ArrayList<>();
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        this.parser = xmlPullParserFactory.newPullParser();
        this.parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        this.parser.setInput(is, null);

        this.manager = context.getAssets();

    }

    public void parseXML() throws XmlPullParserException, IOException {
        int event = this.parser.getEventType();

        while (event != XmlPullParser.END_DOCUMENT) {
            String name = this.parser.getName();

            switch (event) {
                case XmlPullParser.START_TAG:
                    if(name.equals("pokemon")) {
                        this.pokemon = new Pokemon();
                        this.pokemon.setId(Short.parseShort(this.parser.getAttributeValue(null, "id")));
                    } else if(pokemon != null) {
                        if(name.equals("name")) {
                            this.pokemon.setName(this.parser.nextText());
                        } else if(name.equals("types")) {
                            this.pokemon.setType(0, this.parseType(this.parser.getAttributeValue(null, "type1")));
                            this.pokemon.setType(1, this.parseType(this.parser.getAttributeValue(null, "type2")));
                        } else if(name.equals("template")) {
                            this.pokemon.setHeight(Float.parseFloat(this.parser.getAttributeValue(null, "height")));
                            this.pokemon.setWeight(Float.parseFloat(this.parser.getAttributeValue(null, "weight")));
                        } else if(name.equals("abilities")) {
                            this.parseAbility();
                        } else if (name.equals("stats")) {
                            this.parseStats();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = this.parser.getName();
                    if(name.equalsIgnoreCase("pokemon")) {
                        this.pokemons.add(this.pokemon);
                    }
                    break;
            }
            event = this.parser.next();
        }
    }

    private Types parseType(String type) {
        switch (type) {
            case "Normal":  return Types.NORMAL;
            case "Fighting": return Types.FIGHT;
            case "Flying": return Types.FLYING;
            case "Poison": return Types.POISON;
            case "Ground": return Types.GROUND;
            case "Rock": return Types.ROCK;
            case "Bug": return Types.BUG;
            case "Ghost": return Types.GHOST;
            case "Steel": return Types.STEEL;
            case "Fire": return Types.FIRE;
            case "Water": return Types.WATER;
            case "Grass": return Types.GRASS;
            case "Electric": return Types.ELECTR;
            case "Psychic": return Types.PSYCHIC;
            case "Ice": return Types.ICE;
            case "Dragon": return Types.DRAGON;
            case "Dark": return Types.DARK;
            case "Fairy": return Types.FAIRY;
            default: return Types.UKNOWN;
        }
    }

    private void parseAbility() throws XmlPullParserException, IOException {
        InputStream abilityFile = manager.open("data/ability.xml");
        XMLParserAbility ability = new XMLParserAbility(abilityFile);
        short[] id = new short[3];
        id[0] = Short.parseShort(this.parser.getAttributeValue(null, "f"));
        if(!this.parser.getAttributeValue(null, "s").equals("")) {
            id[1] = Short.parseShort(this.parser.getAttributeValue(null, "s"));
        }
        if(!this.parser.getAttributeValue(null, "h").equals("")) {
            id[2] = Short.parseShort(this.parser.getAttributeValue(null, "h"));
        }
        ability.parseXML(id);
        this.pokemon.setAbilities(ability.getAbilities());
        abilityFile.close();
    }

    private void parseStats() throws XmlPullParserException {
        this.pokemon.setHP(Integer.parseInt(this.parser.getAttributeValue(null, "hp")));
        this.pokemon.setAtk(Integer.parseInt(this.parser.getAttributeValue(null, "atk")));
        this.pokemon.setDef(Integer.parseInt(this.parser.getAttributeValue(null, "def")));
        this.pokemon.setSpA(Integer.parseInt(this.parser.getAttributeValue(null, "spa")));
        this.pokemon.setSpD(Integer.parseInt(this.parser.getAttributeValue(null, "spd")));
        this.pokemon.setSpe(Integer.parseInt(this.parser.getAttributeValue(null, "spe")));
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}
