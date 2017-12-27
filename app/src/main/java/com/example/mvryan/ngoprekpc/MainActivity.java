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
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
