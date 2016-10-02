package view;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dinoslayer.pokemonCalculator.R;

/**
 * Created by TheDinoSlayer on 14/08/2016.
 */
public class ViewPokemonData extends View {
    private final Spinner spinnerPokemon;
    private final Spinner spinnerForm;

    private final TextView textType1;
    private final TextView textType2;

    private final EditText editLevel;

    private final TextView textBSHP;
    private final EditText editIVHP;
    private final EditText editEVHP;
    private final TextView textHP;

    private final TextView textBSAtk;
    private final EditText editIVAtk;
    private final EditText editEVAtk;
    private final TextView textAtk;
    private final Spinner modifierAtk;

    private final TextView textBSDef;
    private final EditText editIVDef;
    private final EditText editEVDef;
    private final TextView textDef;
    private final Spinner modifierDef;

    private final TextView textBSSpa;
    private final EditText editIVSpa;
    private final EditText editEVSpa;
    private final TextView textSpa;
    private final Spinner modifierSpa;

    private final TextView textBSSpd;
    private final EditText editIVSpd;
    private final EditText editEVSpd;
    private final TextView textSpd;
    private final Spinner modifierSpd;

    private final TextView textBSSpe;
    private final EditText editIVSpe;
    private final EditText editEVSpe;
    private final TextView textSpe;
    private final Spinner modifierSpe;

    private final Spinner spinnerNature;
    private final Spinner spinnerAbility;
    private final Spinner spinnerItem;
    private final Spinner spinnerStatus;

    public ViewPokemonData(Activity activity) {
        super(activity.getApplicationContext());

        this.spinnerPokemon = (Spinner) activity.findViewById(R.id.spinPokemon);
        this.spinnerForm = (Spinner) activity.findViewById(R.id.spinForm);
        this.textType1 = (TextView) activity.findViewById(R.id.textType1);
        this.textType2 = (TextView) activity.findViewById(R.id.textType2);
        this.editLevel = (EditText) activity.findViewById(R.id.editLevel);

        this.textBSHP = (TextView) activity.findViewById(R.id.textBSHP);
        this.editIVHP = (EditText) activity.findViewById(R.id.editIVHP);
        this.editEVHP = (EditText) activity.findViewById(R.id.editEVHP);
        this.textHP = (TextView) activity.findViewById(R.id.textHP);

        this.textBSAtk = (TextView) activity.findViewById(R.id.textBSAtk);
        this.editIVAtk = (EditText) activity.findViewById(R.id.editIVAtk);
        this.editEVAtk = (EditText) activity.findViewById(R.id.editEVAtk);
        this.textAtk = (TextView) activity.findViewById(R.id.textAtk);
        this.modifierAtk = (Spinner) activity.findViewById(R.id.modifierAtk);

        this.textBSDef = (TextView) activity.findViewById(R.id.textBSDef);
        this.editIVDef = (EditText) activity.findViewById(R.id.editIVDef);
        this.editEVDef = (EditText) activity.findViewById(R.id.editEVDef);
        this.textDef = (TextView) activity.findViewById(R.id.textDef);
        this.modifierDef = (Spinner) activity.findViewById(R.id.modifierDef);

        this.textBSSpa = (TextView) activity.findViewById(R.id.textBSSpa);
        this.editIVSpa = (EditText) activity.findViewById(R.id.editIVSpa);
        this.editEVSpa = (EditText) activity.findViewById(R.id.editEVSpa);
        this.textSpa = (TextView) activity.findViewById(R.id.textSpa);
        this.modifierSpa = (Spinner) activity.findViewById(R.id.modifierSpa);

        this.textBSSpd = (TextView) activity.findViewById(R.id.textBSSpd);
        this.editIVSpd = (EditText) activity.findViewById(R.id.editIVSpd);
        this.editEVSpd = (EditText) activity.findViewById(R.id.editEVSpd);
        this.textSpd = (TextView) activity.findViewById(R.id.textSpd);
        this.modifierSpd = (Spinner) activity.findViewById(R.id.modifierSpd);

        this.textBSSpe = (TextView) activity.findViewById(R.id.textBSSpe);
        this.editIVSpe = (EditText) activity.findViewById(R.id.editIVSpe);
        this.editEVSpe = (EditText) activity.findViewById(R.id.editEVSpe);
        this.textSpe = (TextView) activity.findViewById(R.id.textSpe);
        this.modifierSpe = (Spinner) activity.findViewById(R.id.modifierSpe);

        this.spinnerNature = (Spinner) activity.findViewById(R.id.spinnerNature);
        this.spinnerAbility = (Spinner) activity.findViewById(R.id.spinnerAbility);
        this.spinnerItem = (Spinner) activity.findViewById(R.id.spinnerItem);
        this.spinnerStatus = (Spinner) activity.findViewById(R.id.spinnerStatus);
    }

    public Spinner getSpinnerPokemon() {return spinnerPokemon;}
    public Spinner getSpinnerForm() {return spinnerForm;}
    public TextView getTextType1() {return textType1;}
    public TextView getTextType2() {return textType2;}
    public EditText getEditLevel() {return editLevel;}
    public TextView getTextBSHP() {return textBSHP;}
    public EditText getEditIVHP() {return editIVHP;}
    public EditText getEditEVHP() {return editEVHP;}
    public TextView getTextHP() {return textHP;}
    public TextView getTextBSAtk() {return textBSAtk;}
    public EditText getEditIVAtk() {return editIVAtk;}
    public EditText getEditEVAtk() {return editEVAtk;}
    public TextView getTextAtk() {return textAtk;}
    public Spinner getModifierAtk() {return modifierAtk;}
    public TextView getTextBSDef() {return textBSDef;}
    public EditText getEditIVDef() {return editIVDef;}
    public EditText getEditEVDef() {return editEVDef;}
    public TextView getTextDef() {return textDef;}
    public Spinner getModifierDef() {return modifierDef;}
    public TextView getTextBSSpa() {return textBSSpa;}
    public EditText getEditIVSpa() {return editIVSpa;}
    public EditText getEditEVSpa() {return editEVSpa;}
    public TextView getTextSpa() {return textSpa;}
    public Spinner getModifierSpa() {return modifierSpa;}
    public TextView getTextBSSpd() {return textBSSpd;}
    public EditText getEditIVSpd() {return editIVSpd;}
    public EditText getEditEVSpd() {return editEVSpd;}
    public TextView getTextSpd() {return textSpd;}
    public Spinner getModifierSpd() {return modifierSpd;}
    public TextView getTextBSSpe() {return textBSSpe;}
    public EditText getEditIVSpe() {return editIVSpe;}
    public EditText getEditEVSpe() {return editEVSpe;}
    public TextView getTextSpe() {return textSpe;}
    public Spinner getModifierSpe() {return modifierSpe;}
    public Spinner getSpinnerNature() {return spinnerNature;}
    public Spinner getSpinnerAbility() {return spinnerAbility;}
    public Spinner getSpinnerItem() {return spinnerItem;}
    public Spinner getSpinnerStatus() {return spinnerStatus;}
}
