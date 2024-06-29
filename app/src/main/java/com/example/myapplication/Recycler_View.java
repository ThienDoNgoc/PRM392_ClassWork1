package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recycler_View extends AppCompatActivity {

    ArrayList<ProductModel> products = new ArrayList<>();
    int[] productImages = {R.drawable.abc, R.drawable.abc, R.drawable.abc, R.drawable.abc,
                           R.drawable.abc, R.drawable.abc, R.drawable.abc, R.drawable.abc,
                           R.drawable.abc, R.drawable.abc, R.drawable.abc, R.drawable.abc,
                           R.drawable.abc, R.drawable.abc, R.drawable.abc, R.drawable.abc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        setUpProductModel();

        ProductAdapter adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));


    }
    private void setUpProductModel() {
        String[] productName = getResources().getStringArray(R.array.app_name_products);
        for (int i=0; i<productName.length; i++) {
            products.add(new ProductModel(productName[i], productImages[i]));
        };
    };
}