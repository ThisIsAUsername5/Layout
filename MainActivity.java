package com.example.layouty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Utworzenie listy produktów
        productList = new ArrayList<>();

        productList.add(new Product(
                "Laptop",
                "Laptop do pracy i nauki"
        ));

        productList.add(new Product(
                "Smartfon",
                "Nowoczesny telefon"
        ));

        productList.add(new Product(
                "Tablet",
                "Tablet do przeglądania internetu"
        ));

        productList.add(new Product(
                "Monitor",
                "Monitor 27 cali"
        ));

        productList.add(new Product(
                "Klawiatura",
                "Klawiatura mechaniczna"
        ));

        // Ustawienie sposobu wyświetlania listy
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Podłączenie adaptera
        adapter = new ProductAdapter(productList);

        recyclerView.setAdapter(adapter);
    }
}