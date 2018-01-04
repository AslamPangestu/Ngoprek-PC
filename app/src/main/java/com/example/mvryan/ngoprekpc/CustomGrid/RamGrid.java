package com.example.mvryan.ngoprekpc.CustomGrid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvryan.ngoprekpc.R;

/**
 * Created by mvryan on 22/12/17.
 */

public class RamGrid extends BaseAdapter {

    public Context mContext;
    public String[] name = {
            "ASGARD LEORICE DDR4 HARDCORE GAMING SERIES",
            "Adata DDR4 PC19200 32GB",
            "Vispro DDR4 PC17000 8GB",
            "KLEVV DDR4 CRASS II PC24000",
            "Adata DDR4 XPG PC22400 32GB"
    };
    public int[] id_image = {
            R.drawable.ram1,
            R.drawable.ram2,
            R.drawable.ram3,
            R.drawable.ram4,
            R.drawable.ram5
    };
    public String[] price = {
            "Rp 3.430.000",
            "Rp 3.560.000",
            "Rp 910.000",
            "Rp 2.375.000",
            "Rp 3.290.000"
    };
    public String[] desc = {
            "support amd ryzen.\n" +
                    "\n" +
                    "ada fitur RGB.\n" +
                    "\n" +
                    "Speed 2400 MHZ",
            "gaming series memiliki beberapa pilihan kecepatan, 2133, 2400, 2800 dan 3200 Mhz sudah dilengkapi headspreader.",
            "coba 3",
            "coba 4",
            "coba 5"
    };

    public RamGrid(Context context, String[] name, int[] id_image, String[] price) {
        this.mContext = context;
        this.name = name;
        this.price = price;
        this.id_image = id_image;
    }

    public RamGrid(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_single, null);
        }
        TextView nameText = convertView.findViewById(R.id.nama_txt);
        ImageView gambar = convertView.findViewById(R.id.grid_image);
        TextView hargaText = convertView.findViewById(R.id.harga_txt);
        nameText.setText(name[i]);
        gambar.setImageResource(id_image[i]);
        hargaText.setText(price[i]);
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
