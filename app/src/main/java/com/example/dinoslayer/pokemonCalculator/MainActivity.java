package com.example.dinoslayer.pokemonCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.InputStream;

import controller.XMLParserAbility;
import model.Ability;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display = (TextView) findViewById(R.id.display);
        display.setMovementMethod(new ScrollingMovementMethod());

        try {
            InputStream is = getApplicationContext().getAssets().open("data/ability.xml");

            XMLParserAbility parserAbility = new XMLParserAbility(is);
            short []id = new short[2];
            id[0] = 195;
            id[1] = 34;
            parserAbility.parseXML(id);

            for (Ability a : parserAbility.getAbilities()) {
                String content = "";

                content += "ID : " + a.getId() + "\n";
                content += "Name : " + a.getName() + "\n";
                content += "Effect : " + a.getEffect() + "\n\n";

                display.setText(display.getText() + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
