package edu.quinnipiac.ser210.nutritionapp;

/*
    Jillian Biasotti
    3/22/2018
    Nutritional App Project
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FoodTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_type);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String nameText = intent.getStringExtra("choice");


    }

    //controls when the continue button is pressed
    public void onContinueResult(View view) {

        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
