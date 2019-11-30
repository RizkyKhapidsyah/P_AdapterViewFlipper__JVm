package com.rizkykhapidsyah.p_adapterviewflipper__jvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapterFlipper extends BaseAdapter {

    Context context;
    int[] image;
    String[] name;
    LayoutInflater inflater;

    public MyAdapterFlipper(Context context, int[] image, String[] name) {
        this.context = context;
        this.image = image;
        this.name = name;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.flipper_items, null);

        TextView TV_Names_IDJAVA = convertView.findViewById(R.id.TV_Names_IDXML);
        ImageView IV_Images_IDJAVA = convertView.findViewById(R.id.IV_Images_IDXML);

        TV_Names_IDJAVA.setText(name[position]);
        IV_Images_IDJAVA.setImageResource(image[position]);

        return convertView;
    }
}
