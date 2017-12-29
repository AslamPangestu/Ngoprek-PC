package com.example.mvryan.ngoprekpc;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mvryan on 22/12/17.
 */

public class CustomGrid extends BaseAdapter {

    Context mContext;
    String[] name = {
            "AMD A10-7400P",
            "AMD A10-8400P",
            "AMD A10-9400P",
            "AMD A10-7500P",
            "AMD A10-7600P",
            "AMD A10-7700P"
    };
    int[] id_image = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };
    String[] price = {
            "Rp 5.000.000",
            "Rp 6.000.000",
            "Rp 4.000.000",
            "Rp 2.000.000",
            "Rp 7.000.000",
            "Rp 1.000.000"
    };
    String[] desc = {
            "coba 1",
            "coba 2",
            "coba 3",
            "coba 4",
            "coba 5",
            "coba 6",
    };

    public CustomGrid(Context context, String[] name, int[] id_image, String[] price) {
        this.mContext = context;
        this.name = name;
        this.price = price;
        this.id_image = id_image;
    }

    public CustomGrid(Context context) {
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
