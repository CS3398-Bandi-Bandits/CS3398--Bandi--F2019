/*
* author: Jose Herrera
* */

package com.example.guiprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ExerciseListAdapter extends ArrayAdapter<ListViewBlock> {

    private Context mContext;
    int mResource;

    public ExerciseListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ListViewBlock> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();
        String setData = getItem(position).getSetData();

        ListViewBlock listViewBlock = new ListViewBlock(name,setData);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvSet = (TextView) convertView.findViewById(R.id.textView2);

        tvName.setText(name);
        tvSet.setText(setData);

        return convertView;

    }
}
