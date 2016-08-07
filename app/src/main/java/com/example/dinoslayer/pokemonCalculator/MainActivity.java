package com.example.dinoslayer.pokemonCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.InputStream;

import controller.XMLParserPokemon;
import model.Ability;
import model.Pokemon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display = (TextView) findViewById(R.id.display);
        display.setMovementMethod(new ScrollingMovementMethod());

        try {
            InputStream is = getApplicationContext().getAssets().open("data/pokemon.xml");

            XMLParserPokemon parserPokemon = new XMLParserPokemon(is, getApplicationContext());
            parserPokemon.parseXML();

            for (Pokemon p : parserPokemon.getPokemons()) {
                String content = "";

                content += "ID : " + p.getId() + "\n";
                content += "Name : " + p.getName() + "\n";
                content += "Type 1 : " + p.getType()[0].getDisplay() + "\n";
                content += "Type 2 : " + p.getType()[1].getDisplay() + "\n";
                content += "Height : " + p.getHeight() + " Weight : " + p.getWeight() + "\n";
                content += "Ability : \n";
                for(Ability a : p.getAbilities() ) {
                    content += a.getName() + "\n";
                }
                content += "HP : " + p.getHP() + "\n";
                content += "Attack : " + p.getAtk() + "\n";
                content += "Defense : " + p.getDef() + "\n";
                content += "Special Attack : " + p.getSpA() + "\n";
                content += "Special Defense : " + p.getSpD() + "\n";
                content += "Speed : " + p.getSpe() + "\n\n";

                display.setText(display.getText() + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
