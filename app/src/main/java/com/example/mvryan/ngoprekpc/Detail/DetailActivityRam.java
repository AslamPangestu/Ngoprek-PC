package com.example.mvryan.ngoprekpc.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvryan.ngoprekpc.CustomGrid.HddGrid;
import com.example.mvryan.ngoprekpc.CustomGrid.RamGrid;
import com.example.mvryan.ngoprekpc.R;

/**
 * Created by mvryan on 28/12/17.
 */

public class DetailActivityRam extends AppCompatActivity {

    int pos = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        pos = i.getExtras().getInt("position");

        final RamGrid ramGrid = new RamGrid(this);

        TextView judul = findViewById(R.id.judul);
        ImageView gambar = findViewById(R.id.img);
        TextView desc = findViewById(R.id.desc);
        TextView harga = findViewById(R.id.price);

        judul.setText(ramGrid.name[pos]);
        gambar.setImageResource(ramGrid.id_image[pos]);
        desc.setText(ramGrid.desc[pos]);
        harga.setText(ramGrid.price[pos]);

    }
}
