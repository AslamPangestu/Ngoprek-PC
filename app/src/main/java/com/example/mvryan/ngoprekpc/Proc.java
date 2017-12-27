package com.example.mvryan.ngoprekpc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by mvryan on 27/12/17.
 */

public class Proc extends Activity{

    GridView grid;

    String[] name = {
            "AMD A10-7400P",
            "AMD A10-7400P",
            "AMD A10-7400P",
            "AMD A10-7400P",
            "AMD A10-7400P",
            "AMD A10-7400P"
    };
    int[] id_image = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground
    };
    String[] price = {
            "Rp 5.000.000",
            "Rp 5.000.000",
            "Rp 5.000.000",
            "Rp 5.000.000",
            "Rp 5.000.000",
            "Rp 5.000.000"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_proc);

        CustomGrid gridAdapter = new CustomGrid
                (Proc.this,name,id_image,price);
        grid = findViewById(R.id.grid_view);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Proc.this,name[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
