package controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.example.dinoslayer.pokemonCalculator.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Nature;
import model.Pokemon;
import view.ViewPokemonData;

/**
 * Created by TheDinoSlayer on 15/08/2016.
 */
public class ControlPokemonData  extends Activity {
    private ViewPokemonData viewPokemonData;
    private List<Pokemon> pokemons;
    private Pokemon pokemon;

    public ControlPokemonData(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_data);

        try {
            this.viewPokemonData = new ViewPokemonData(this);
            XMLParserPokemon parserPokemon = new XMLParserPokemon(getApplicationContext().getAssets().open("data/pokemon.xml"), getApplicationContext());
            parserPokemon.parseXML();
            this.pokemons = new ArrayList<>();
            this.pokemons = parserPokemon.getPokemons();
            this.pokemon = this.pokemons.get(0);

            final List<String> pokeList = new ArrayList<>();
            for(Pokemon p: pokemons) {
                pokeList.add(p.getName());
            }

            ArrayAdapter<String> pokeAdapter = new ArrayAdapter<>(this, R.layout.array_adapter, pokeList);
            this.viewPokemonData.getSpinnerPokemon().setAdapter(pokeAdapter);
            this.pokemon = this.pokemons.get(0);

            this.pokemon.setLevel(Byte.parseByte("100"));
            this.viewPokemonData.getEditLevel().setText(Byte.toString(this.pokemon.getLevel()));

            this.viewPokemonData.getTextBSHP().setText(Integer.toString(this.pokemon.getHP()));
            this.viewPokemonData.getTextBSAtk().setText(Integer.toString(this.pokemon.getAtk()));
            this.viewPokemonData.getTextBSDef().setText(Integer.toString(this.pokemon.getDef()));
            this.viewPokemonData.getTextBSSpa().setText(Integer.toString(this.pokemon.getSpA()));
            this.viewPokemonData.getTextBSSpd().setText(Integer.toString(this.pokemon.getSpD()));
            this.viewPokemonData.getTextBSSpe().setText(Integer.toString(this.pokemon.getSpe()));

            this.viewPokemonData.getSpinnerNature().setAdapter(new ArrayAdapter<>(this, R.layout.array_adapter, Nature.values()));
            this.viewPokemonData.getSpinnerNature().setSelection(8);
            this.pokemon.setNature(Nature.valueOf(this.viewPokemonData.getSpinnerNature().getSelectedItem().toString().toUpperCase()));

            calculateHP();
            calculateStats("Attack");
            calculateStats("Defense");
            calculateStats("SpAtk");
            calculateStats("SpDef");
            calculateStats("Speed");

            this.viewPokemonData.getModifierAtk().setSelection(6);
            this.viewPokemonData.getModifierDef().setSelection(6);
            this.viewPokemonData.getModifierSpa().setSelection(6);
            this.viewPokemonData.getModifierSpd().setSelection(6);
            this.viewPokemonData.getModifierSpe().setSelection(6);

        } catch (IOException e) {
            catchException("Error to open file", e);
        } catch (XmlPullParserException e) {
            catchException("Error to parse data", e);
        } catch (Exception e) {
            catchException("Unknown error", e);
        }
    }

    private void calculateHP() {
        int finalStat = (2 * this.pokemon.getHP() + Integer.parseInt(this.viewPokemonData.getEditIVHP().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVHP().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + this.pokemon.getLevel() + 10;
        this.viewPokemonData.getTextHP().setText(Integer.toString(finalStat));
    }

    private void calculateStats(String stat) {
        int finalStat;
        switch (stat) {
            case "Attack":
                finalStat = (2 * this.pokemon.getAtk() + Integer.parseInt(this.viewPokemonData.getEditIVAtk().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVAtk().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + 5;
                if(this.pokemon.getNature() == Nature.ADAMANT || this.pokemon.getNature() == Nature.BRAVE || this.pokemon.getNature() == Nature.LONELY || this.pokemon.getNature() == Nature.NAUGHTY) {
                    finalStat *= 1.1;
                } else if(this.pokemon.getNature() == Nature.BOLD || this.pokemon.getNature() == Nature.CALM || this.pokemon.getNature() == Nature.MODEST || this.pokemon.getNature() == Nature.TIMID) {
                    finalStat *= 0.9;
                }
                this.viewPokemonData.getTextAtk().setText(Integer.toString(finalStat));
                break;
            case "Defense":
                finalStat = (2 * this.pokemon.getDef() + Integer.parseInt(this.viewPokemonData.getEditIVDef().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVDef().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + 5;
                if(this.pokemon.getNature() == Nature.BOLD || this.pokemon.getNature() == Nature.IMPISH || this.pokemon.getNature() == Nature.LAX || this.pokemon.getNature() == Nature.RELAXED) {
                    finalStat *= 1.1;
                } else if(this.pokemon.getNature() == Nature.GENTLE || this.pokemon.getNature() == Nature.HASTY || this.pokemon.getNature() == Nature.LONELY || this.pokemon.getNature() == Nature.MILD) {
                    finalStat *= 0.9;
                }
                this.viewPokemonData.getTextDef().setText(Integer.toString(finalStat));
                break;
            case "SpAtk":
                finalStat = (2 * this.pokemon.getSpA() + Integer.parseInt(this.viewPokemonData.getEditIVSpa().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVSpa().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + 5;
                if(this.pokemon.getNature() == Nature.MILD || this.pokemon.getNature() == Nature.MODEST || this.pokemon.getNature() == Nature.RASH || this.pokemon.getNature() == Nature.QUIET) {
                    finalStat *= 1.1;
                } else if(this.pokemon.getNature() == Nature.ADAMANT || this.pokemon.getNature() == Nature.CAREFUL || this.pokemon.getNature() == Nature.IMPISH || this.pokemon.getNature() == Nature.JOLLY) {
                    finalStat *= 0.9;
                }
                this.viewPokemonData.getTextSpa().setText(Integer.toString(finalStat));
                break;
            case "SpDef":
                finalStat = (2 * this.pokemon.getSpD() + Integer.parseInt(this.viewPokemonData.getEditIVSpd().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVSpd().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + 5;
                if(this.pokemon.getNature() == Nature.CALM || this.pokemon.getNature() == Nature.CAREFUL || this.pokemon.getNature() == Nature.GENTLE || this.pokemon.getNature() == Nature.SASSY) {
                    finalStat *= 1.1;
                } else if(this.pokemon.getNature() == Nature.LAX || this.pokemon.getNature() == Nature.NAIVE || this.pokemon.getNature() == Nature.NAUGHTY || this.pokemon.getNature() == Nature.RASH) {
                    finalStat *= 0.9;
                }
                this.viewPokemonData.getTextSpd().setText(Integer.toString(finalStat));
                break;
            case "Speed":
                finalStat = (2 * this.pokemon.getSpe() + Integer.parseInt(this.viewPokemonData.getEditIVSpe().getText().toString()) + (Integer.parseInt(this.viewPokemonData.getEditEVSpe().getText().toString()) / 4)) * (this.pokemon.getLevel() / 100) + 5;
                if(this.pokemon.getNature() == Nature.HASTY || this.pokemon.getNature() == Nature.JOLLY || this.pokemon.getNature() == Nature.NAIVE || this.pokemon.getNature() == Nature.TIMID) {
                    finalStat *= 1.1;
                } else if(this.pokemon.getNature() == Nature.BRAVE || this.pokemon.getNature() == Nature.QUIET || this.pokemon.getNature() == Nature.RELAXED || this.pokemon.getNature() == Nature.SASSY) {
                    finalStat *= 0.9;
                }
                this.viewPokemonData.getTextSpe().setText(Integer.toString(finalStat));
                break;
            default:break;
        }
    }

    private void catchException(String title, Exception e) {
        new AlertDialog.Builder(ControlPokemonData.this)
                .setTitle(title)
                .setMessage(e.getMessage())
                .setCancelable(false)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(-1);
                    }
                }).create().show();
    }
}
