package com.example.tpglobale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    List<Car> cars;
    LayoutInflater layoutInflater;

    public ListViewAdapter(List<Car> cars, Context context) {
        this.cars = cars;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class AfficherItem
    {
        ImageView image;
        TextView titre;
        TextView desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AfficherItem item;
        if(convertView == null)
        {
            item = new AfficherItem();
            convertView = layoutInflater.inflate(R.layout.list_view,null);
            item.image = convertView.findViewById(R.id.image);
            item.titre = convertView.findViewById(R.id.titre);
            item.desc = convertView.findViewById(R.id.desc);
            convertView.setTag(item);
        }else{
            item = (AfficherItem) convertView.getTag();
        }
        item.image.setImageResource(cars.get(position).getImage());
        item.titre.setText(cars.get(position).getTitre());
        item.desc.setText(cars.get(position).getDesc());

        return convertView;

    }


}
