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

public class VgaGrid extends BaseAdapter {

    public Context mContext;
    public String[] name = {
            "Galax GeForce GTX 980 TI HOF 6GB DDR5",
            "Galax GeForce GTX 970 HOF 4GB DDR5",
            "Asus GeForce GTX TITAN X 12GB DDR5",
            "Leadtek Quadro Kepler K5200 8GB DDR5",
            "Nvidia Quadro SDI output for Kepler"
    };
    public int[] id_image = {
            R.drawable.vga1,
            R.drawable.vga2,
            R.drawable.vga3,
            R.drawable.vga4,
            R.drawable.vga5
    };
    public String[] price = {
            "Rp 10.899.000",
            "Rp 6.199.000",
            "Rp 18.300.000",
            "Rp 34.090.000",
            "Rp 48.550.000"
    };
    public String[] desc = {
            "coba 1",
            "coba 2",
            "coba 3",
            "coba 4",
            "coba 5"
    };

    public VgaGrid(Context context, String[] name, int[] id_image, String[] price) {
        this.mContext = context;
        this.name = name;
        this.price = price;
        this.id_image = id_image;
    }

    public VgaGrid(Context context) {
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
