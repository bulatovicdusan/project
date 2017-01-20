package com.example.dusan.food.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.dusan.food.model.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wubon on 1/10/2017.
 */
public class DatabaseAdapter {

    public static final String TAG = DatabaseAdapter.class.getSimpleName();


    Context c;
    SQLiteDatabase db;
    MyDBHandler myDBHandler;

    public DatabaseAdapter(Context c){
        this.c = c;
        myDBHandler = new MyDBHandler(c);
    }


    public DatabaseAdapter openDB(){

        try {
            db = myDBHandler.getWritableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        return this;
    }




    public DatabaseAdapter openDBA(){

        try {
            db = myDBHandler.getReadableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        return this;
    }

    public void CloseDB(){
        try {
            myDBHandler.close();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
    }



    public long insert(String name, String description){
        SQLiteDatabase db = myDBHandler.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(myDBHandler.COLUMN_NAME, name);
            values.put(myDBHandler.COLUMN_DESCRIPTION, description);

            return db.insert(MyDBHandler.TABLE_RESTAURANT, null, values);
        }catch (SQLiteException e){
            Log.e(TAG, "Ne radi insert: " + e.toString());
        }
        return 0;
    }


    public Cursor read(){
        SQLiteDatabase db = myDBHandler.getReadableDatabase();
        String[] columns = {myDBHandler.COLUMN_ID, myDBHandler.COLUMN_NAME, myDBHandler.COLUMN_DESCRIPTION, myDBHandler.COLUMN_IMAGE_RESTAURANT, myDBHandler.COLUMN_RESTAURANT_ADDRESS,myDBHandler.COLUMN_STARTHOUR,  myDBHandler.COLUMN_ENDHOUR, myDBHandler.COLUMN_PHONE, myDBHandler.COLUMN_EMAIL};

        return db.query(myDBHandler.TABLE_RESTAURANT, columns, null, null, null, null, null );
    }

    public Cursor read2(){
        SQLiteDatabase db = myDBHandler.getReadableDatabase();
        String[] columns = {myDBHandler.COLUMN_MEAL_ID, myDBHandler.COLUMN_MEAL_NAME, myDBHandler.COLUMN_MEAL_DESCRIPTION, myDBHandler.COLUMN_MEAL_PRICE, myDBHandler.COLUMN_MEAL_IMAGE,myDBHandler.COLUMN_ID_RESTORANA, myDBHandler.COLUMN_MEAL_TAG};

        return db.query(myDBHandler.TABLE_MEALS, columns, null, null, null, null, null );
    }

    public Cursor read3(){
        SQLiteDatabase db = myDBHandler.getReadableDatabase();
        String[] columns = {myDBHandler.COLUMN_TAG_ID, myDBHandler.COLUMN_TAG_NAME};

        return db.query(myDBHandler.TABLE_MEALS, columns, null, null, null, null, null );
    }





}
