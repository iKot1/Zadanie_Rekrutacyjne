package com.example.irek.zadanie_rekrutacyjne;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Irek on 2016-11-03.
 */

public class MyListAdapter extends ArrayAdapter<Element> {

    private LayoutInflater myInflater;
    private ArrayList<Element> elements;
    private int myViewResourceId;

    public MyListAdapter(Context context, int resource, ArrayList<Element> elements) {
        super(context, resource, elements);
        this.elements=elements;
        myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myViewResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = myInflater.inflate(myViewResourceId, null);

        Element element = elements.get(position);

        if (element != null) {
            TextView counter = (TextView) convertView.findViewById(R.id.tv_counter);
            LinearLayout ll_field = (LinearLayout) convertView.findViewById(R.id.layout_element_list);

            String valueCounter;

            if (element.getColor() == "RED") {
                ll_field.setBackgroundColor(Color.RED);
                valueCounter = element.getCounter();

            } else {
                ll_field.setBackgroundColor(Color.BLUE);
                int counterInt = Integer.valueOf(element.getCounter()) * 3;
                valueCounter = String.valueOf(counterInt);

            }
            counter.setText(valueCounter);
        }

        return convertView;
    }
}
