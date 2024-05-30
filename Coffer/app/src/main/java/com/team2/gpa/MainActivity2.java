package com.team2.coffer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    //1.Animals    2.Electronics    3.Flowers    4.Food    5.Monuments    6.Music    7.Sports    8.Stationary    9.Transport
    String[] categories = {"ANIMALS", "ELECTRONICS", "FLOWERS", "FOOD", "MONUMENTS", "MUSIC", "SPORTS", "STATIONARY", "TRANSPORT"};
    String s;
    int count=0;
    int[] password_categories = new int[3];
    ArrayList<String> selected_categories = new ArrayList<>();

    public void switchLayout(View v)
    {
        Intent i = new Intent(this, MainActivity3.class);
        Bundle bundle = new Bundle();
        bundle.putIntArray("password_categories" , password_categories);
        i.putExtras(bundle);
        Log.i("Info", "redirecting to MainActivity3...");
        startActivity(i);
    }

    public void reset(View v)
    {
        count = 0;
        s = "";
        selected_categories.clear();
        password_categories = new int[3];
        TextView display = findViewById(R.id.categoryDisplay);
        display.setText(s);
        Log.i("Info", "ALL RESET.");
    }

    @SuppressLint("NonConstantResourceId")
    public void enterCategory(View view)
    {
        if(count < 3)
        {
            setContentView(R.layout.activity_main2);
            TextView display = findViewById(R.id.categoryDisplay);
            switch(view.getId())
            {
                case R.id.button1:
                    password_categories[count] = 0;
                    break;
                case R.id.button2:
                    password_categories[count] = 1;
                    break;
                case R.id.button3:
                    password_categories[count] = 2;
                    break;
                case R.id.button4:
                    password_categories[count] = 3;
                    break;
                case R.id.button5:
                    password_categories[count] = 4;
                    break;
                case R.id.button6:
                    password_categories[count] = 5;
                    break;
                case R.id.button7:
                    password_categories[count] = 6;
                    break;
                case R.id.button8:
                    password_categories[count] = 7;
                    break;
                case R.id.button9:
                    password_categories[count] = 8;
                    break;
            }
            Log.i("Info", "Button-" + categories[password_categories[count]] + " registered.\npassword_categories[" + count + "] = " + password_categories[count]);
            selected_categories.add(categories[password_categories[count]]);
            s = "" + selected_categories;
            display.setText(s);
            count++;
        }
        if(count == 3)
            switchLayout(view);
    }

    public void credit(View view)
    {
        Toast.makeText(getApplicationContext(), "Created by\nII Yr (2021-22) IT-B Team-2\nUnder the course - Product Realization", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main2);
    }
}