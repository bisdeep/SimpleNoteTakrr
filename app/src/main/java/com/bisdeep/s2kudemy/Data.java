package com.bisdeep.s2kudemy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data extends SQLiteOpenHelper {
    //now we'll create a table
    private static final String LIST_TABLE = "listbl";//table name
    private static final String ID_COL = "id";//first column contains id
    private static final String LIST_COL = "list"; //second column

    public Data(Context context){
        super(context, "database.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String tblCreator = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(300) NOT NULL);", LIST_TABLE, ID_COL, LIST_COL);

        db.execSQL(tblCreator);
        String listItemCreator = String.format("INSERT INTO %s (%s) VALUES ('%s');", LIST_TABLE, LIST_COL, "Insert Text here:");
        db.execSQL(listItemCreator);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
    public void writeList(String list){
        SQLiteDatabase db = getWritableDatabase();

        String query = String.format("INSERT INTO %s (%s) VALUES ('%s');", LIST_TABLE, LIST_COL, list);
        db.execSQL(query);
    }
    public String retrieveList(){
        SQLiteDatabase db = getReadableDatabase();

        String query = String.format("SELECT %s FROM %s", LIST_COL, LIST_TABLE);

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToLast();

        String listString = String.format(cursor.getString(0));

        cursor.close();
        db.close();

        return listString;


    }
}
