package edu.quinnipiac.ser210.nutritionapp;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment implements View.OnClickListener{


    public RadioButton rButton1;
    public RadioButton rButton2;
    public TextView text;
    public Button button;

    public Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        text = (TextView)layout.findViewById(R.id.topText);

        RadioGroup radioGroup=(RadioGroup)layout.findViewById(R.id.radioGroup);
        rButton1=(RadioButton)layout.findViewById(R.id.foodTypeButton);
        rButton2=(RadioButton)layout.findViewById(R.id.UPCButton);

        button = (Button) layout.findViewById(R.id.continueButton);
        button.setOnClickListener(this);

        return layout;

    }



    //controls what happens when on continue is clicked
    public void onContinue(View view) {

        if (rButton1.isChecked()) {
            Intent intent = new Intent(getActivity(), FoodTypeActivity.class);
            startActivity(intent);
        } else if (rButton2.isChecked()) {
            Intent intent = new Intent(getActivity(), UPCActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View v) {
        onContinue(v);
    }
}
