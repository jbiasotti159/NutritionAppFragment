package edu.quinnipiac.ser210.nutritionappfrag;


/*
    Jillian Biasotti
    3/22/2018
    Nutritional App Project
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResultActivity extends AppCompatActivity {

    public String url, code;
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        view = findViewById(R.id.test);

        Intent intent = getIntent();
        code = intent.getStringExtra("name");

        view.setText("you chose " + code);

        url = "https://nutritionix-api.p.rapidapi.com/v1_1/item?upc=" + code;
        new Network().execute(url);

    }

    //populates the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //controls what happens when the actions are selected
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        boolean iscolor = true;
        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.resultLayout);
        TextView title = (TextView)findViewById(R.id.title);
        switch (item.getItemId()) {
            case R.id.action_help:
                showDialog(this, "Help", "This Nutrition App aims to help people easily access nutritional information while on the go! This application uses the Nutritionix API available on RapidAPI's and this app was created by Jillian Biasotti");
                return true;

            case R.id.action_paint:
                Toast.makeText(this, "You painted this page!", Toast.LENGTH_LONG).show();
                if(iscolor)
                {
                    layout.setBackgroundColor(Color.BLACK);
                    view.setTextColor(Color.WHITE);
                    title.setTextColor(Color.WHITE);
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

    //designs the dialog box that shows when certain actions are pressed

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


    //AsyncTask used to connect to the url and gather information from the API
    private class Network extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String foodDataJSON = null;

            try{
                URL url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key","8267e69849msh50454c6cb8b515dp149b89jsn935699dc0ac6");
                urlConnection.connect();
                InputStream in = urlConnection.getInputStream();
                if(in == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(in));
                foodDataJSON = getBufferStringFromBuffer(reader).toString();
                Log.d("JSON", foodDataJSON);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null){
                    try{
                        reader.close();
                    } catch (IOException e){
                        Log.e("e", "Error" + e.getMessage());
                        return null;
                    }
                }
            }
            return foodDataJSON;
        }

        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    String displayString = new JSONHandler().getFoodData(result);
                    view.setText(displayString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        private StringBuffer getBufferStringFromBuffer(BufferedReader br) throws Exception{
            StringBuffer buffer = new StringBuffer();

            String line;
            while((line = br.readLine()) != null){
                buffer.append(line + '\n');
            }

            if (buffer.length() == 0)
                return null;

            return buffer;
        }
    }



}
