package com.example.mvryan.ngoprekpc.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvryan.ngoprekpc.CustomGrid.HddGrid;
import com.example.mvryan.ngoprekpc.CustomGrid.VgaGrid;
import com.example.mvryan.ngoprekpc.R;

/**
 * Created by mvryan on 28/12/17.
 */

public class DetailActivityVga extends AppCompatActivity {

    int pos = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        pos = i.getExtras().getInt("position");

        final VgaGrid vgaGrid = new VgaGrid(this);

        TextView judul = findViewById(R.id.judul);
        ImageView gambar = findViewById(R.id.img);
        TextView desc = findViewById(R.id.desc);
        TextView harga = findViewById(R.id.price);

        judul.setText(vgaGrid.name[pos]);
        gambar.setImageResource(vgaGrid.id_image[pos]);
        desc.setText(vgaGrid.desc[pos]);
        harga.setText(vgaGrid.price[pos]);

    }
}
