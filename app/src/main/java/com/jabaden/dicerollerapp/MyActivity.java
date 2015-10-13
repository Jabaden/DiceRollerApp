package com.jabaden.dicerollerapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

import java.util.Random;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void rollDice(View view){
        Log.d("Roll", "in the roll dice function");
        int numberOfDice = 0;
        int totalValue = 0;
        String result;
        EditText editText = (EditText) findViewById(R.id.numberOfDice);
        try{
            numberOfDice = Integer.parseInt(editText.getText().toString());
        }catch(NumberFormatException nfe){
            Log.d("rollDice", "couldnt parse" + nfe);
        }
        for(int i = 0; i < numberOfDice; i++){

            int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            Log.d("rollDice", "r is " + randomNumber);
            totalValue += randomNumber;

        }
        result = Integer.toString(totalValue);
        TextView tv = (TextView) findViewById(R.id.rollResultBox);
        tv.setText(result);
    }
}
