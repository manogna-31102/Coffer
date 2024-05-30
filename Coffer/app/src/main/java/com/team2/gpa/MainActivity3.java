package com.team2.coffer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity3 extends AppCompatActivity {
    //1.Animals    2.Electronics    3.Flowers    4.Food    5.Monuments    6.Music    7.Sports    8.Stationary    9.Transport
    int[] img_animals = {R.drawable.animal_1, R.drawable.animal_2, R.drawable.animal_3, R.drawable.animal_4, R.drawable.animal_5, R.drawable.animal_6, R.drawable.animal_7, R.drawable.animal_8, R.drawable.animal_9, R.drawable.animal_10, R.drawable.animal_11, R.drawable.animal_12, R.drawable.animal_13, R.drawable.animal_14, R.drawable.animal_15, R.drawable.animal_16, R.drawable.animal_17, R.drawable.animal_18, R.drawable.animal_19};
    int[] img_electronics = {R.drawable.electronics_1, R.drawable.electronics_2, R.drawable.electronics_3, R.drawable.electronics_4, R.drawable.electronics_5, R.drawable.electronics_6, R.drawable.electronics_7, R.drawable.electronics_8, R.drawable.electronics_9, R.drawable.electronics_10, R.drawable.electronics_11, R.drawable.electronics_12, R.drawable.electronics_13};
    int[] img_flowers = {R.drawable.flower_1, R.drawable.flower_2, R.drawable.flower_3, R.drawable.flower_4, R.drawable.flower_5, R.drawable.flower_6, R.drawable.flower_7, R.drawable.flower_8, R.drawable.flower_9, R.drawable.flower_10, R.drawable.flower_11, R.drawable.flower_12};
    int[] img_food = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3, R.drawable.food_4, R.drawable.food_5, R.drawable.food_6, R.drawable.food_7, R.drawable.food_8};
    int[] img_monuments = {R.drawable.monument_1, R.drawable.monument_2, R.drawable.monument_3, R.drawable.monument_4, R.drawable.monument_5, R.drawable.monument_6, R.drawable.monument_7, R.drawable.monument_8, R.drawable.monument_9, R.drawable.monument_10, R.drawable.monument_11, R.drawable.monument_12};
    int[] img_music = {R.drawable.music_1, R.drawable.music_2, R.drawable.music_3, R.drawable.music_4};
    int[] img_sports = {R.drawable.sport_1, R.drawable.sport_2, R.drawable.sport_3, R.drawable.sport_4, R.drawable.sport_5, R.drawable.sport_6, R.drawable.sport_7, R.drawable.sport_8, R.drawable.sport_9, R.drawable.sport_10, R.drawable.sport_11, R.drawable.sport_12, R.drawable.sport_13, R.drawable.sport_14};
    int[] img_stationary = {R.drawable.stationary_1, R.drawable.stationary_2, R.drawable.stationary_3, R.drawable.stationary_4, R.drawable.stationary_5, R.drawable.stationary_6, R.drawable.stationary_7, R.drawable.stationary_8};
    int[] img_transport = {R.drawable.transport_1, R.drawable.transport_2, R.drawable.transport_3, R.drawable.transport_4, R.drawable.transport_5, R.drawable.transport_6, R.drawable.transport_7, R.drawable.transport_8, R.drawable.transport_9, R.drawable.transport_10, R.drawable.transport_11, R.drawable.transport_12};

    int[][] img_all_multi = {img_animals, img_electronics, img_flowers, img_food, img_monuments, img_music, img_sports, img_stationary, img_transport};
    int[] cnt = {0,0,0,0,0,0,0,0,0};

    int i, count = 1, random_button_idx, random_password_image_idx, random_image_idx, random_category_idx, buttonId;
    int[] password_categories, password_img_array;
    boolean flag = true;
    public void imageButtonClicked(View view)
    {
        Log.i("Info", "Button Image Pressed");
        if(view.getId() != buttonId)
            flag = false;
        if(count == 1)
            password_img_array = img_all_multi[password_categories[0]];
        else if(count == 2)
            password_img_array = img_all_multi[password_categories[1]];
        else if(count == 3)
            password_img_array = img_all_multi[password_categories[2]];
        if(count <= 3) // This condition is to stop the function from being called after else statement because there is a delay in closing the app using finishAffinity.
            GenerateGrid(password_img_array);
        else
        {
            if(flag)
            {
                Toast.makeText(getApplicationContext(), "Validation Passed.", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Validation Failed. Please Try Again.", Toast.LENGTH_LONG).show();
            }
            retry(view);
        }
    }

    public void GenerateGrid(int[] password_img_array)
    {
        ImageButton b1 = findViewById(R.id.imageButton1);
        ImageButton b2 = findViewById(R.id.imageButton2);
        ImageButton b3 = findViewById(R.id.imageButton3);
        ImageButton b4 = findViewById(R.id.imageButton4);
        ImageButton b5 = findViewById(R.id.imageButton5);
        ImageButton b6 = findViewById(R.id.imageButton6);
        ImageButton b7 = findViewById(R.id.imageButton7);
        ImageButton b8 = findViewById(R.id.imageButton8);
        ImageButton b9 = findViewById(R.id.imageButton9);
        ImageButton[] image_button_array = {b1, b2, b3, b4, b5, b6, b7, b8, b9};

        //Generating a random image_button number and a random index for selecting random image from password_img_array.
        random_button_idx = (int) (Math.random() * 9);
        random_password_image_idx = (int) (Math.random() * password_img_array.length);
        //Inserting a random image selected from the password_img_array into a random button.
        image_button_array[random_button_idx].setImageResource((int) password_img_array[random_password_image_idx]);
        buttonId = image_button_array[random_button_idx].getId();
        Log.i("Info", "Layer-" + count + " buttonImage-" + random_button_idx + " Password Image Generated.");
        random_category_idx = (int) (Math.random() * img_all_multi.length);
        for (i=0; i < cnt.length; i++)
        {
            cnt[i] = 0;
        }
        for (i=0; i < 9; i++)
        {
            if(i != random_button_idx)
            {
                while(random_category_idx == (password_categories[count-1]) || cnt[random_category_idx] == 1)
                {
                    random_category_idx = (int) (Math.random() * img_all_multi.length);
                }
                random_image_idx = (int) (Math.random() * img_all_multi[random_category_idx].length);
                image_button_array[i].setImageResource((int) img_all_multi[random_category_idx][random_image_idx]);
                cnt[random_category_idx] = 1;
                Log.i("Info", "Layer-" + count + " buttonImage-" + i + " Category:" + random_category_idx + " Generated.");
            }
        }
        Log.i("Info", "Layer-" + count + " All Images Generated.");
        count++;
    }

    public void retry(View v)
    {
        count = 1;
        flag = true;
        Log.i("Info", "RESET.");
        GenerateGrid(img_all_multi[password_categories[0]]);
    }

    public void reset(View v)
    {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
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
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        password_categories = bundle.getIntArray("password_categories");
        Log.i("Info", "password_categories received in MainActivity3.");
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                GenerateGrid(img_all_multi[password_categories[0]]);
            }
        }, 10);
    }
}