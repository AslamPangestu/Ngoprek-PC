package com.example.mvryan.ngoprekpc;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mvryan.ngoprekpc.Fragment.HddFragment;
import com.example.mvryan.ngoprekpc.Fragment.ProcFragment;
import com.example.mvryan.ngoprekpc.Fragment.RamFragment;
import com.example.mvryan.ngoprekpc.Fragment.VgaFragment;

/**
 * Created by mvryan on 22/12/17.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return  new ProcFragment();
        }else  if(position == 1){
            return new VgaFragment();
        }else if (position==2){
            return new RamFragment();
        }else{
            return new HddFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.processor_fragment);
            case 1:
                return mContext.getString(R.string.vga_fragment);
            case 2:
                return mContext.getString(R.string.ram_fragment);
            case 3:
                return mContext.getString(R.string.hdd_fragment);
            default:
                return null;
        }
    }
}
