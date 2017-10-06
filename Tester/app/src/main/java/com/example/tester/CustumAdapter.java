package com.example.tester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustumAdapter extends BaseAdapter {

    private ArrayList<ItemData> itemDatas = null;
    private LayoutInflater layoutInflater = null;

    public CustumAdapter(ArrayList<ItemData> itemDatas, Context ctx) {
        this.itemDatas = itemDatas;
        this.layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private void setItemDatas(ArrayList<ItemData> itemDatas) {
        this.itemDatas = itemDatas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return (itemDatas != null) ? itemDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return (itemDatas != null && (0 <= position && position < itemDatas.size()) ? itemDatas.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return (itemDatas != null && (0 <= position && position < itemDatas.size()) ? position : 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

            viewHolder.TextView_Title = (TextView)convertView.findViewById(R.id.txtTitle_item);
            viewHolder.TextView_Description = (TextView)convertView.findViewById(R.id.txtDescription_item);
        }

        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ItemData itemData = itemDatas.get(position);
        viewHolder.TextView_Title.setText(itemData.Title);
        viewHolder.TextView_Description.setText(itemData.Description);

        return convertView;
    }

}