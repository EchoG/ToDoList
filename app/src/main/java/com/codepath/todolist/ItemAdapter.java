package com.codepath.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by chenrangong on 8/6/17.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, List<Item> items){
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        TextView tvContent = (TextView) convertView.findViewById(R.id.tvContent);
        TextView tvPriority = (TextView) convertView.findViewById(R.id.tvPriority);
        TextView tvDueDate = (TextView) convertView.findViewById(R.id.tvDueDate);
        tvContent.setText(item.content);
        tvPriority.setText(item.priority);

        if(item.dueDate == null){
            tvDueDate.setText("");
        }else{
            DateFormat sdf = new java.text.SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(item.dueDate);
            tvDueDate.setText(date);
        }

        return convertView;
    }

}
