package controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.dinoslayer.pokemonCalculator.R;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Nature;
import model.Pokemon;
import model.Status;
import model.Types;
import view.ViewPokemonData;

/**
 * Created by TheDinoSlayer on 15/08/2016.
 */
public class ControlPokemonData extends Activity {
    private ViewPokemonData viewPokemonData;
    private List<Pokemon> pokemons;
    private Pokemon pokemon;
    private enum Stats {
        HP,
        ATTACK,
        DEFENSE,
        SPATK,
        SPDEF,
        SPEED
    }

    public ControlPokemonData() {

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
            for (Pokemon p : pokemons) {
                pokeList.add(p.getName());
            }

            ArrayAdapter<String> pokeAdapter = new ArrayAdapter<>(this, R.layout.array_adapter, pokeList);
            this.viewPokemonData.getSpinnerPokemon().setAdapter(pokeAdapter);
            this.pokemon = this.pokemons.get(0);

            this.viewPokemonData.getTextType1().setText(this.pokemon.getType()[0].getDisplay());
            if (!this.pokemon.getType()[1].equals(Types.UKNOWN)) {
                this.viewPokemonData.getTextType2().setText(this.pokemon.getType()[1].getDisplay());
            }

            this.pokemon.setLevel(Byte.parseByte("100"));
            this.viewPokemonData.getEditLevel().setText(Byte.toString(this.pokemon.getLevel()));
            this.viewPokemonData.getEditLevel().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override
                public void afterTextChanged(Editable editable) { editLevel(editable); }
            });

            this.viewPokemonData.getTextBSHP().setText(Integer.toString(this.pokemon.getHP()));
            this.viewPokemonData.getTextBSAtk().setText(Integer.toString(this.pokemon.getAtk()));
            this.viewPokemonData.getTextBSDef().setText(Integer.toString(this.pokemon.getDef()));
            this.viewPokemonData.getTextBSSpa().setText(Integer.toString(this.pokemon.getSpA()));
            this.viewPokemonData.getTextBSSpd().setText(Integer.toString(this.pokemon.getSpD()));
            this.viewPokemonData.getTextBSSpe().setText(Integer.toString(this.pokemon.getSpe()));

            this.editStats(Stats.HP);
            this.editStats(Stats.ATTACK);
            this.editStats(Stats.DEFENSE);
            this.editStats(Stats.SPATK);
            this.editStats(Stats.SPDEF);
            this.editStats(Stats.SPEED);

            this.viewPokemonData.getSpinnerNature().setAdapter(new ArrayAdapter<>(this, R.layout.array_adapter, Nature.values()));
            this.viewPokemonData.getSpinnerNature().setSelection(8);
            this.pokemon.setNature(Nature.valueOf(this.viewPokemonData.getSpinnerNature().getSelectedItem().toString().toUpperCase()));

            this.viewPokemonData.getModifierAtk().setSelection(6);
            this.viewPokemonData.getModifierDef().setSelection(6);
            this.viewPokemonData.getModifierSpa().setSelection(6);
            this.viewPokemonData.getModifierSpd().setSelection(6);
            this.viewPokemonData.getModifierSpe().setSelection(6);

            AbilityAdapter abilityAdapter = new AbilityAdapter(this, R.layout.array_adapter, this.pokemon.getAbilities());
            this.viewPokemonData.getSpinnerAbility().setAdapter(abilityAdapter);

            this.viewPokemonData.getSpinnerStatus().setAdapter(new ArrayAdapter<>(this, R.layout.array_adapter, Status.values()));

            this.viewPokemonData.getEditIVHP().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) { editIV(editable, viewPokemonData.getEditIVHP(), Stats.HP);}});
            this.viewPokemonData.getEditIVAtk().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) { editIV(editable, viewPokemonData.getEditIVAtk(), Stats.ATTACK);}});
            this.viewPokemonData.getEditIVDef().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) { editIV(editable, viewPokemonData.getEditIVDef(), Stats.DEFENSE);}});
            this.viewPokemonData.getEditIVSpa().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editIV(editable, viewPokemonData.getEditIVSpa(), Stats.SPATK);}});
            this.viewPokemonData.getEditIVSpd().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editIV(editable, viewPokemonData.getEditIVSpd(), Stats.SPDEF);}});
            this.viewPokemonData.getEditIVSpe().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editIV(editable, viewPokemonData.getEditIVSpe(), Stats.SPEED);}});

            this.viewPokemonData.getEditEVHP().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVHP(), Stats.HP);}});
            this.viewPokemonData.getEditEVAtk().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVAtk(), Stats.ATTACK);}});
            this.viewPokemonData.getEditEVDef().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVDef(), Stats.DEFENSE);}});
            this.viewPokemonData.getEditEVSpa().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVSpa(), Stats.SPATK);}});
            this.viewPokemonData.getEditEVSpd().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVSpd(), Stats.SPDEF);}});
            this.viewPokemonData.getEditEVSpe().addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                @Override public void afterTextChanged(Editable editable) {editEV(editable, viewPokemonData.getEditEVSpe(), Stats.SPEED);}});

        } catch (IOException e) {
            catchException("Error to open file", e);
        } catch (XmlPullParserException e) {
            catchException("Error to parse data", e);
        }
    }

    private void editStats(Stats stats) {
        switch (stats) {
            case HP:
                this.viewPokemonData.getTextHP().setText(Integer.toString(new CalculationStats().calculateHP(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVHP().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVHP().getText().toString())
                )));
                break;
            case ATTACK:
                this.viewPokemonData.getTextAtk().setText(Integer.toString(new CalculationStats().calculateAtk(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVAtk().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVAtk().getText().toString())
                )));
                break;
            case DEFENSE:
                this.viewPokemonData.getTextDef().setText(Integer.toString(new CalculationStats().calculateDef(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVDef().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVDef().getText().toString())
                )));
                break;
            case SPATK:
                this.viewPokemonData.getTextSpa().setText(Integer.toString(new CalculationStats().calculateSpa(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVSpa().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVSpa().getText().toString())
                )));
                break;
            case SPDEF:
                this.viewPokemonData.getTextSpd().setText(Integer.toString(new CalculationStats().calculateSpd(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVSpd().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVSpd().getText().toString())
                )));
                break;
            case SPEED:
                this.viewPokemonData.getTextSpe().setText(Integer.toString(new CalculationStats().calculateSpe(
                        this.pokemon, Integer.parseInt(this.viewPokemonData.getEditIVSpe().getText().toString()), Integer.parseInt(this.viewPokemonData.getEditEVSpe().getText().toString())
                )));
                break;
        }
    }

    private void editLevel(Editable editable) {
        if(editable.toString().isEmpty() || Integer.parseInt(editable.toString()) <= 0) {
            this.viewPokemonData.getEditLevel().setText("1");
            Selection.setSelection(this.viewPokemonData.getEditLevel().getText(), this.viewPokemonData.getEditLevel().length());
        }  else if(Integer.parseInt(editable.toString()) > 100) {
           this.viewPokemonData.getEditLevel().setText("100");
        }
        this.pokemon.setLevel(Byte.parseByte(viewPokemonData.getEditLevel().getText().toString()));
        editStats(Stats.HP);
        editStats(Stats.ATTACK);
        editStats(Stats.DEFENSE);
        editStats(Stats.SPATK);
        editStats(Stats.SPDEF);
        editStats(Stats.SPEED);
    }

    private void editIV(Editable editable, EditText IVText, Stats stats) {
        if(editable.toString().isEmpty()) {
            IVText.setText("0");
            Selection.setSelection(IVText.getText(), IVText.length());
        } else if(Integer.parseInt(editable.toString()) > 31) {
            IVText.setText("31");
            Selection.setSelection(IVText.getText(), IVText.length());
        }
        editStats(stats);
    }

    private void editEV(Editable editable, EditText EVText, Stats stats) {
        if(editable.toString().isEmpty()) {
            EVText.setText("0");
            Selection.setSelection(EVText.getText(), EVText.length());
        } else if(Integer.parseInt(editable.toString()) > 252) {
            EVText.setText("252");
            Selection.setSelection(EVText.getText(), EVText.length());
        }
        editStats(stats);
    }

    private void catchException(String title, Exception e) {
        new AlertDialog.Builder(ControlPokemonData.this)
                .setTitle(title)
                .setMessage(e.getMessage())
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();
    }
}