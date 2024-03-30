package com.example.restaurantapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    RecyclerView.Adapter myadapter;
    ArrayList<Restaurant> restaurants;
    Button btnadd;
    ImageButton btnsearch;
    TextInputEditText filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        manager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        restaurants= new ArrayList<>();

        SharedPreferences sPref = getSharedPreferences("Restaurant", MODE_PRIVATE);
        String name = sPref.getString("name", "");
        String loc = sPref.getString("location", "");
        String desc = sPref.getString("desc", "");
        String phone = sPref.getString("phone", "");
        int rating = sPref.getInt("rating", 0);

        restaurants.add(new Restaurant(rating,name, loc, phone, desc));



        restaurants.add(new Restaurant(5,"HuQQa restaurant", "Dubai", "03215555555", "Best Restaurnat"));
        restaurants.add(new Restaurant(2,"Heera Chargha", "Lahore", "03251515", "Best Chargha"));

        myadapter = new Restaurant_Adapter(this,restaurants);
        recyclerView.setAdapter(myadapter);

        btnadd=findViewById(R.id.btnadd);

        filter = findViewById(R.id.filter);
        btnsearch=findViewById(R.id.btnsearch);




        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = filter.getText().toString();
                filterList(searchText);

            }
        }



        );

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddScreen.class);
                startActivity(intent);

            }
        });



    }
    private void filterList(String searchText) {
        ((Restaurant_Adapter)myadapter).getFilter().filter(searchText);
    }

}
