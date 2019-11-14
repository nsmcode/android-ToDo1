package com.example.lxa_todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class ToDoAdapter extends BaseAdapter {

    private List<Item> data;

    public void setData(List<Item> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        convertView = inflater.inflate(R.layout.list_item, parent, false);
        TextView txtItem = convertView.findViewById(R.id.Item);
        CheckBox check = convertView.findViewById(R.id.checkBoxDone);
        TextView txtDateTime = convertView.findViewById(R.id.txtDateTime);

        txtItem.setText(data.get(position).getItem());
        check.setChecked(data.get(position).isStatus());
        txtDateTime.setText(data.get(position).getDate() + " (" + data.get(position).getTime() + ")");

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.get(position).setStatus(isChecked);
            }
        });

        return convertView;
    }
}
