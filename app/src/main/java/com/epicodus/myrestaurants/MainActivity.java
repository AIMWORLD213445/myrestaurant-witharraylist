package com.epicodus.myrestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.addRestaurantButton) Button mAddRestaurantButton;
    @Bind(R.id.addRestaurant) EditText mAddRestaurant;

    private ArrayList<String> restaurants =  new ArrayList<String>(Arrays.asList("Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface headerFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        mAppNameTextView.setTypeface(headerFont);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        mFindRestaurantsButton.setTypeface(buttonFont);


        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });

        mAddRestaurantButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String restaurant = mAddRestaurant.getText().toString();
                restaurants.add(restaurant);
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                String[] restaurantsArray = restaurants.toArray(new String[0]);
                intent.putExtra("restaurants",restaurantsArray);
                startActivity(intent);
            }
        });

    }
}
