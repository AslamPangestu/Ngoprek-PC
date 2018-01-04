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

public class ProcGrid extends BaseAdapter {

    public Context mContext;
    public String[] name = {
            "Intel Core I7 4960X",
            "Intel Core I7 4930K",
            "Intel Xeon E5-2687Wv2",
            "AMD Vishera FX-9590",
            "AMD Godavari A10-7870K",
    };
    public int[] id_image = {
            R.drawable.proc1,
            R.drawable.proc2,
            R.drawable.proc3,
            R.drawable.proc4,
            R.drawable.proc5
    };
    public String[] price = {
            "Rp 15.010.000",
            "Rp 8.130.000",
            "Rp 30.298.000",
            "Rp 3.410.000",
            "Rp 1.950.000"
    };
    public String[] desc = {
            "coba 1",
            "coba 2",
            "coba 3",
            "coba 4",
            "coba 5"
    };

    public ProcGrid(Context context, String[] name, int[] id_image, String[] price) {
        this.mContext = context;
        this.name = name;
        this.price = price;
        this.id_image = id_image;
    }

    public ProcGrid(Context context) {
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
