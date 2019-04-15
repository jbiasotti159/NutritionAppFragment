package edu.quinnipiac.ser210.nutritionapp;

/*
    Jillian Biasotti
    3/22/2018
    Nutritional App Project
 */
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public RadioButton rButton1;
    public RadioButton rButton2;
    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Main fragment = new Main();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.MainActivityContainer,fragment);
        ft.commit();




    }

    //controls what happens when on continue is clicked
    public void onContinue(View view) {

        if (rButton1.isChecked()) {
            Intent intent = new Intent(this, FoodTypeActivity.class);
            startActivity(intent);
        } else if (rButton2.isChecked()) {
            Intent intent = new Intent(this, UPCActivity.class);
            startActivity(intent);
        }
    }

    //populates the action bar with the items from menu_main.xml
        @Override
        public boolean onCreateOptionsMenu (Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        //controls what happens when the actions in the toolbar are selected
        @Override
        public boolean onOptionsItemSelected (MenuItem item)
        {
            boolean iscolor = true;
            View layout = getSupportFragmentManager().findFragmentById(R.id.MainActivityContainer).getView();
            switch (item.getItemId()) {
                case R.id.action_help:
                    showDialog(this, "Help", "This Nutrition App aims to help people easily access nutritional information while on the go! This application uses the Nutritionix API available on RapidAPI's and this app was created by Jillian Biasotti");
                    return true;

                case R.id.action_paint:
                    Toast.makeText(this, "You painted this page!", Toast.LENGTH_LONG).show();
                    if(iscolor)
                    {
                        layout.setBackgroundColor(Color.CYAN);
                        iscolor = false;
                    }
                    else
                    {
                        layout.setBackgroundColor(Color.WHITE);
                        iscolor = true;
                    }
                    return true;

                case R.id.action_send:
                    Toast.makeText(this, "You sent this page!", Toast.LENGTH_LONG).show();
                    showDialog(this, "Message", "Thanks for sharing!");
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }


    //This is the code for the dialog message box that pops up for the help option
    public void showDialog(Activity activity, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (title != null) builder.setTitle(title);

        builder.setMessage(message);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        builder.show();
    }



}
