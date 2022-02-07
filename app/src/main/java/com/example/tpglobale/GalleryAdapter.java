package com.example.tpglobale;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

    private Context context;

    private Integer[] images = {R.drawable.bmw,R.drawable.mercedec,R.drawable.porsh};

    public GalleryAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource((Integer) getItem(position));
        imageView.setLayoutParams(new Gallery.LayoutParams(500,500));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
