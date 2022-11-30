package com.example.baikiemtra2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Item> listItem;

    public ItemAdapter(Context context, int layout, List<Item> listItem) {
        this.context = context;
        this.layout = layout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView ten;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.ten = view.findViewById(R.id.txtTenLine);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Item item = listItem.get(i);
        holder.ten.setText(item.getTenNgonNgu());
        return view;
    }
}
