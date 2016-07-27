package com.example.dinoslayer.pokemon_calculataor;

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
            parserAbility.parseXML();

            for (Ability a : parserAbility.getAbilities()) {
                String content = "";

                content += "id : " + a.getId() + "\n";
                content += "name : " + a.getName() + "\n";
                content += "effect : " + a.getEffect() + "\n";

                display.setText(display.getText() + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
