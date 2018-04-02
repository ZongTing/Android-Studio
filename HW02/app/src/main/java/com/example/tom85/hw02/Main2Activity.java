package com.example.tom85.hw02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView foodNameTextView;
    private TextView foodAddressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mImageView = findViewById(R.id.imageView);
        foodNameTextView = findViewById(R.id.foodNameTextView);
        foodAddressTextView = findViewById(R.id.foodAddressTextView);

        int foodId = getIntent().getExtras().getInt("FOOD_ID");
        String foodName = getIntent().getExtras().getString("FOOD_NAME");
        String foodAddress = getIntent().getExtras().getString("FOOD_ADDRESS");

        switch (foodId) {
            case 1:
                foodNameTextView.setText(foodName);
                mImageView.setBackgroundResource(R.drawable.tofu);
                foodAddressTextView.setText(foodAddress);
                break;
            case 2:
                foodNameTextView.setText(foodName);
                mImageView.setBackgroundResource(R.drawable.blood);
                foodAddressTextView.setText(foodAddress);
                break;
            case 3:
                foodNameTextView.setText(foodName);
                mImageView.setBackgroundResource(R.drawable.ice);
                foodAddressTextView.setText(foodAddress);
                break;
            case 4:
                foodNameTextView.setText(foodName);
                mImageView.setBackgroundResource(R.drawable.opt);
                foodAddressTextView.setText(foodAddress);
                break;
        }
    }
}
