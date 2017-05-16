package com.example.a127107.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 127107 on 16/5/2017.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> objects;
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tv1,tv2,tv3;

    public TaskArrayAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        this.objects = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }

    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tv1 = (TextView)
                rowView.findViewById(R.id.tvID);
        tv2 = (TextView)
                rowView.findViewById(R.id.tvDesc);
        tv3 = (TextView)
                rowView.findViewById(R.id.tvDate);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        Task object = objects.get(pos);
        // Set the TextView to show the object info
        tv1.setText(object.getId() + "");
        tv2.setText(object.getDescription());
        tv3.setText(object.getDate());
        // Return this row that is being populated.
        return rowView;
    }




}
