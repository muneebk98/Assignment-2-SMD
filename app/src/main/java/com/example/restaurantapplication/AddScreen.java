package com.example.restaurantapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class AddScreen extends AppCompatActivity {
    TextInputEditText r_name, loc, phone,desc, rating;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        r_name =findViewById(R.id.r_name);
        loc = findViewById(R.id.loc);
        phone=findViewById(R.id.phone);
        desc=findViewById(R.id.desc);
        rating=findViewById(R.id.rating);
        btnadd=findViewById(R.id.btnadd);

        SharedPreferences sPref = getSharedPreferences("Restaurant", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", Objects.requireNonNull(r_name.getText()).toString());
                editor.putString("location",Objects.requireNonNull(loc.getText()).toString());
                editor.putString("desc",Objects.requireNonNull(desc.getText()).toString());
                editor.putString("phone",Objects.requireNonNull(phone.getText()).toString());
                int ratingValue = Integer.parseInt(rating.getText().toString());
                editor.putInt("rating", ratingValue);
                editor.apply();


                Intent intent = new Intent(AddScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}
