package com.example.a19soece11036;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String TAG="DatabaseHelper";
    private static final String TABLE_NAME="record";
    private static final String col1="date";
    private static final String col2="time";
    private static final String col3="odo";
    private static final String col4="cost";
    private static final String col5="cost";

    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTable = "CREATE TABLE" + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + col2 +col3 +col4 +col5+"TEXT)";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
