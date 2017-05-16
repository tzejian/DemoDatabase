package com.example.a127107.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnGetTask;
    TextView tvResults;
    ArrayAdapter aa;
    ArrayList<String> al;
    ListView lv;
    ArrayList<Task> alTask ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button)findViewById(R.id.button);
        btnGetTask = (Button)findViewById(R.id.button2);
        tvResults = (TextView)findViewById(R.id.textView);
        lv = (ListView)findViewById(R.id.lvTask);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //create dbhelper
                DBHelper db = new DBHelper(MainActivity.this);

                alTask = db.getTasks();
                aa = new TaskArrayAdapter(MainActivity.this,R.layout.row,alTask);
                lv.setAdapter(aa);

                //
                db.insertTask("dont go school","25 April 2017");
                db.close();
            }
        });

        btnGetTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);

            }
        });


    }
}
