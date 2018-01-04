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

public class HddGrid extends BaseAdapter {

    public Context mContext;
    public String[] name = {
            "WDC SATA III RED 6TB",
            "WDC Purple For CCTV 4TB",
            "Seagate SATA SV 35 4TB",
            "Hitachi 4TB",
            "Toshiba Sata III 3TB"
    };
    public int[] id_image = {
            R.drawable.hdd1,
            R.drawable.hdd2,
            R.drawable.hdd3,
            R.drawable.hdd4,
            R.drawable.hdd5
    };
    public String[] price = {
            "Rp 3.380.000",
            "Rp 2.040.000",
            "Rp 2.050.000",
            "Rp 2.260.000",
            "Rp 1.240.000"
    };
    public String[] desc = {
            "Hard disk ini mempunyai 4 pin data dan 7 pin power yang artinya hard disk ini memiliki kecepatan akses lebih cepat dibanding hard disk jenis IDE. Selain memiliki kecepatan yang lebih cepat dibanding dengan Hard disk IDE, Hard disk SATA ini tidak memiliki jumper karena tidak memerlukan settingan. Untuk kapasitasnya, Hard disk SATA variannya lebih sedikit dari pada hard disk jenis IDE.",
            "Drive WD AV-GP adalah pilihan keren, tenang dan dapat diandalkan untuk aplikasi AV 24/7 yang selalu ada. Mereka dirancang untuk media center, media server, surveillance, signage digital dan sistem AV lainnya yang membutuhkan audio dan video yang sempurna, low heat, low power dan kehandalan jangka panjang.",
            "Sangat sesuai untuk\n" +
                    "Desktop berkinerja tinggi, aplikasi desktop profesional kreatif, game",
            "coba 4",
            "coba 5"
    };

    public HddGrid(Context context, String[] name, int[] id_image, String[] price) {
        this.mContext = context;
        this.name = name;
        this.price = price;
        this.id_image = id_image;
    }

    public HddGrid(Context context) {
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
