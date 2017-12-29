package com.example.mvryan.ngoprekpc;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by mvryan on 28/12/17.
 */

public class DetailActivity extends AppCompatActivity {

    int pos = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        pos = i.getExtras().getInt("position");

        final CustomGrid customGrid = new CustomGrid(this);

        TextView judul = findViewById(R.id.judul);
        ImageView gambar = findViewById(R.id.img);
        TextView desc = findViewById(R.id.desc);
        TextView harga = findViewById(R.id.price);

        judul.setText(customGrid.name[pos]);
        gambar.setImageResource(customGrid.id_image[pos]);
        desc.setText(customGrid.desc[pos]);
        harga.setText(customGrid.price[pos]);

    }
}
