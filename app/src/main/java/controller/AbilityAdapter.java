package controller;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import model.Ability;

/**
 * Created by TheDinoSlayer on 27/08/2016.
 */
public class AbilityAdapter extends ArrayAdapter<Ability> {
    private Context context;
    private List<Ability> abilities;

    public AbilityAdapter(Context context, int textViewResourceId, List<Ability> abilities) {
        super(context, textViewResourceId, abilities);
        this.context = context;
        this.abilities = abilities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(this.context);
        label.setTextColor(Color.BLACK);
        label.setText(abilities.get(position).getName());
        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(this.context);
        label.setTextColor(Color.BLACK);
        label.setText(abilities.get(position).getName());
        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        return label;
    }
}
