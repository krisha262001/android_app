package com.example.a19soece11036;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.os.Bundle;

import java.util.ArrayList;

public class FuelRecord extends AppCompatActivity {
    private static final String TAG="FuelRecord";
    DatabaseHelper databaseHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_record);

        listView = (ListView) findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG,"populateListView: Displaying  data in the ListView");
        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
    }
}