package com.example.dusan.food.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wubon on 1/10/2017.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food1.db*";
    public static final String TABLE_RESTAURANT = "restaurants";
    public static final String TABLE_MEALS = "meals";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MEAL_ID ="id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MEAL_NAME = "nameMeal";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_MEAL_DESCRIPTION = "descriptionMeal";
    public static final String COLUMN_MEAL_PRICE = "price";
    public static final String COLUMN_IMAGE_RESTAURANT = "imageRestaurant";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_RESTAURANT + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_NAME + " TEXT , " +
                COLUMN_DESCRIPTION + " TEXT " +
                ");";
        db.execSQL(query);

        String query2 = " CREATE TABLE " + TABLE_MEALS + "(" +
                COLUMN_MEAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_MEAL_NAME + " TEXT , " +
                COLUMN_MEAL_DESCRIPTION + " TEXT , " +
                COLUMN_MEAL_PRICE + " DOUBLE " +
                ");";
        db.execSQL(query2);


        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" +COLUMN_NAME +","+ COLUMN_DESCRIPTION +") VALUES ('Index House', 'Sandwiches, Pancakes, Grill, Serbian food...')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" +COLUMN_NAME +","+ COLUMN_DESCRIPTION +") VALUES ('Pizzeria Savoca', 'Serbian food, Grill, Sadnwiches..')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" +COLUMN_NAME +","+ COLUMN_DESCRIPTION +") VALUES ('Toster', 'Sandwiches, Pancakes, Grill, Serbian food...')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" +COLUMN_NAME +","+ COLUMN_DESCRIPTION +") VALUES ('Giros Land', 'Grill, Serbian food, Greek food...')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + ") VALUES ('Roma', 'Sandwiches, Italian food, Pizza, Grill..')");


        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +") VALUES ('Sandwich', 'Awesome...' , 250)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +") VALUES ('Pancakes', 'Good...', 180)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +") VALUES ('Pizza', 'Nice...', 990)");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEALS);
        onCreate(db);
    }
}