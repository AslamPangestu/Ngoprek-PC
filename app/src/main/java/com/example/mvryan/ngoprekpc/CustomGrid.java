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

public class CustomGrid extends BaseAdapter{

    private Context mContext;
    private final String[] name;
    private final String[] price;
    private final int[] id_image;

    public CustomGrid(Context c, String[] name, int[] id_image, String[] price) {
            mContext = c;
            this.name = name;
            this.price = price;
            this.id_image = id_image;
    }

    //private final int[] id;

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single,null);

            TextView nameText = grid.findViewById(R.id.nama_txt);
            ImageView gambar = grid.findViewById(R.id.grid_image);
            TextView hargaText = grid.findViewById(R.id.harga_txt);

            nameText.setText(name[i]);
            gambar.setImageResource(id_image[i]);
            hargaText.setText(price[i]);
        }else {
            grid = convertView;
        }
        return grid;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
