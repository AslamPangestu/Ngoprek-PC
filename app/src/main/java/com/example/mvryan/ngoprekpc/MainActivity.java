package com.example.mvryan.ngoprekpc;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mvryan.ngoprekpc.Fragment.HddFragment;
import com.example.mvryan.ngoprekpc.Fragment.ProcFragment;
import com.example.mvryan.ngoprekpc.Fragment.RamFragment;
import com.example.mvryan.ngoprekpc.Fragment.VgaFragment;

public class MainActivity extends AppCompatActivity implements HddFragment.OnFragmentInteractionListener
        ,ProcFragment.OnFragmentInteractionListener
        ,RamFragment.OnFragmentInteractionListener
        ,VgaFragment.OnFragmentInteractionListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);

        SimpleFragmentPagerAdapter fragmentAdapter =
                new SimpleFragmentPagerAdapter(this,getSupportFragmentManager());

        viewPager.setAdapter(fragmentAdapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        CustomGrid gridAdapter = new CustomGrid
                (this,name,id_image,price);
        grid = findViewById(R.id.grid_view);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,name[+i],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
