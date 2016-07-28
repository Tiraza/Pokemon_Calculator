package com.example.dinoslayer.pokemonCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.InputStream;

//import controller.XMLParserAbility;
import controller.XMLParserAttack;
//import model.Ability;
import model.Attack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display = (TextView) findViewById(R.id.display);
        display.setMovementMethod(new ScrollingMovementMethod());

        try {
            InputStream is = getApplicationContext().getAssets().open("data/attack.xml");

            XMLParserAttack parserAttack = new XMLParserAttack(is);
            parserAttack.parseXML();

            for (Attack a : parserAttack.getAttacks()) {
                String content = "";

                content += "ID : " + a.getId() + "\n";
                content += "Name : " + a.getName() + "\n";
                content += "Type : " + a.getType().getDisplay() + "\n";
                content += "Power : " + a.getPower() + "\n";
                content += "Category : " + a.getCategory().getDisplay() + "\n\n";

                display.setText(display.getText() + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
