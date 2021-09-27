package com.example.a19soece11036;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String TAG="DatabaseHelper";
    private static final String TABLE_NAME="record";
    private static final String COL1="id";
    private static final String COL2="date";
    private static final String COL3="time";
    private static final String COL4="odo";
    private static final String COL5="fuel";
    private static final String COL6="cost";

    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTable = "CREATE TABLE " + TABLE_NAME + "("
                + COL1 + "INTEGER PRIMARY KEY," + COL2 +
                "DATE," + COL3 + "TIME," + COL4 + "INTEGER,"
                + COL5 + "INTEGER" +  COL6 + "INTEGER" +")";
        //  String createTable = "CREATE TABLE" + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 +COL3 +COL4 +COL5++COL6"TEXT)";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean addData(int item){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);
        contentValues.put(COL3,item);
        contentValues.put(COL4,item);
        contentValues.put(COL5,item);
        contentValues.put(COL6,item);
        Log.d(TAG,"addData: Adding" + item +"to" +TABLE_NAME);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }else{
            return true;
        }

    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}