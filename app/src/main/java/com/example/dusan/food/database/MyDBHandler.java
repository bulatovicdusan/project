package com.example.dusan.food.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dusan.food.model.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wubon on 1/10/2017.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food9.db*";
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
    public static final String COLUMN_RESTAURANT_ADDRESS = "address";
    public static final String COLUMN_STARTHOUR = "startHour";
    public static final String COLUMN_ENDHOUR = "endHour";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ID_RESTORANA= "idRestorana";
    public static final String COLUMN_TAG_ID = "tagid";
    public static final String COLUMN_TAG_NAME = "tagName";
    public static final String COLUMN_MEAL_TAG = "mealtag";
    public static final String TABLE_TAG = "tags";




    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_RESTAURANT + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_NAME + " TEXT , " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_IMAGE_RESTAURANT + " TEXT, " +
                COLUMN_RESTAURANT_ADDRESS + " TEXT, " +
                COLUMN_STARTHOUR + " INTEGER , " +
                COLUMN_ENDHOUR + " INTEGER , " +
                COLUMN_PHONE + " TEXT , " +
                COLUMN_EMAIL + " TEXT " +

                ");";
        db.execSQL(query);

        String query2 = " CREATE TABLE " + TABLE_MEALS + "(" +
                COLUMN_MEAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_MEAL_NAME + " TEXT , " +
                COLUMN_MEAL_DESCRIPTION + " TEXT , " +
                COLUMN_MEAL_PRICE + " DOUBLE, " +
                COLUMN_ID_RESTORANA + " INTEGER ," +
                COLUMN_MEAL_TAG + " INTEGER, " +
                "FOREIGN KEY ("+ COLUMN_ID_RESTORANA +" ) REFERENCES " + TABLE_RESTAURANT + "(" + COLUMN_ID +
                "));";
        db.execSQL(query2);



        String query3 = " CREATE TABLE " + TABLE_TAG + "(" +
                COLUMN_TAG_ID + " INTEGER PRIMARY KEY ," +
                COLUMN_TAG_NAME + " TEXT  " +
                ");";
        db.execSQL(query3);


        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + "," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + "," + COLUMN_ENDHOUR + "," + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Index House', 'Sandwiches, Pancakes, Grill, Serbian food...', 'indexHouse.jpg', 'Futoska 1', 8,11,'064123454','indexhouse@gmail.com')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + "," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + "," + COLUMN_ENDHOUR + ","  + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Pizzeria Savoca', 'Serbian food, Grill, Sadnwiches..','savoca.jpg', 'Bulevar Oslobodjenja 41', 10,12,'065138841','savocapizzeria@gmail.com')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" +COLUMN_NAME +","+ COLUMN_DESCRIPTION +"," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + ","  + COLUMN_ENDHOUR + ","  + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Toster', 'Sandwiches, Pancakes, Grill, Serbian food...','toster.jpg', 'Bulevar Slobodana Jovanovica 12', 7,10,'060388122','toster@gmail.com')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + "," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + ","  + COLUMN_ENDHOUR + "," + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Giros Land', 'Grill, Serbian food, Greek food...','girosssss.png', 'Laze Teleckog 23', 8,12,'0631231231','girosland@gmail.com')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + "," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + ","  + COLUMN_ENDHOUR + ","  + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Roma', 'Sandwiches, Italian food, Pizza, Grill..','roma.jpg', 'Novosadskog sajma 4', 9,11,'06214913484','roma@gmail.com')");
        db.execSQL("INSERT INTO " + TABLE_RESTAURANT + "(" + COLUMN_NAME + "," + COLUMN_DESCRIPTION + "," + COLUMN_IMAGE_RESTAURANT + "," + COLUMN_RESTAURANT_ADDRESS + "," + COLUMN_STARTHOUR + "," + COLUMN_ENDHOUR + "," + COLUMN_PHONE + "," + COLUMN_EMAIL + ") VALUES ('Big Burrito', 'Great Mexican tastes! Make burrito of your choice.','bigburrito.jpg', 'Bulevar kralja Petra I 58', 7,10,'06458712','bigburrito@gmail.com')");

        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Sandwich', 'Pelat, origano, cheese, kulen' , 170, 1,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Index Sandwich', 'Pelat, origano, cheese' , 270, 1,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Sandwich Chicken breast', 'Chicken breasts, cheese, mushrooms' , 250, 1,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Index meal sandwich', 'Pelat, origano, cheese, kulen' , 300, 1,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Raffaello pancake','Raffaello, plazma cakes' , 190, 1,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Young beef sausage','Pork, cheese', 210, 3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Gyros vegetarian','Tortilla, salad, French fries',160,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Chicken Gyros','100 grams of meat, French fries',240,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Gyros portion','200 grams of meat, French fries',450,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Gyros Double','170 grams of meat, French fries', 350,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Pizza Premium','Peeled tomato, ham, cheese, kulen, smoked ham, corn, mushrooms, olives, sour cream, oregano', 890, 2,1)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Sausage','Pork, spicy spices',230,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Chicken breast','150 grams Young beef bacon, cheese, peeled tomato',250,5,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Burrito Chicken','150 grams. Young beef. Onion, bacon, cheese',270,5,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Pancake cherry','275 grams. Eruocream black, cherry, plazma cakes', 200, 2,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Snikers pancake','300 grams. Snikers,plazma cakes', 220, 4,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Pizza Savoca', 'Peeled tomato, ham, cheese, kulen, mushrooms, pepperoni, oregano' , 250, 2,1)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Capricciosa','Peeled tomato, ham, cheese, mushrooms, oregano',900, 2,1)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Vegetariana','Peeled tomato, mushrooms, paprika, corn, olives, oregano, rocket', 950, 2,1)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Arrabbiata','Spicy. Peeled tomato, garlic, onion, virgin olive oil, basil, peperoncino, parmesan', 500,4,5)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Bolognese','Minced meat, peeled tomato, red wine, carrot, virgin olive oil, garlic, onion, basil, parsley, parmesan, celery, bacon', 550,2,5)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Carbonara','Pancetta, sour cream, white wine, parmesan', 470,2,5)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Chicken breast','100 grams of meat, French fries', 320,4,3)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Pancake Banana','300 grams. Eurocream black, banana, plazma cakes', 180,4,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Pancake cheese cake','365 grams. Eruocream white, forest fruit, sour cream, cheese, plazma cakes', 240,4,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Nutela Pancake','250 grams. Nutela, banana, plazma cakes', 195,4,2)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Spicy Burger','Burger meat 60 grams, kulen, melted cheese, burger mayonnaise, heinz hot, red onion, fresh chili pepper',300,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Burger + French fires','Burger meat 60 grams, melted cheese, burger mayonnaise, heinz ketchup, iceberg, pickles, French fries',240,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Bacon Burger','Burger meat 60 grams, pancetta, melted cheese, iceberg, pickles, burger mayonnaise, heinz ketchup',240,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Double Burger','Burger meat 120 grams, melted cheese, burger mayonnaise, heinz ketchup, iceberg, pickles',240,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Hot Burger','100 grams of meat,chill',240,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Special Burger','300 grams of meat, French fries',240,3,4)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Special ','100 grams of meat,chill',240,5,5)");
        db.execSQL("INSERT INTO " + TABLE_MEALS + "(" +COLUMN_MEAL_NAME +","+ COLUMN_MEAL_DESCRIPTION +"," + COLUMN_MEAL_PRICE +"," +COLUMN_ID_RESTORANA + "," + COLUMN_MEAL_TAG + ") VALUES ('Double Bacon Burger','300 grams of meat, French fries',240,5,5)");

        db.execSQL("INSERT INTO " + TABLE_TAG + "(" + COLUMN_TAG_ID + "," +COLUMN_TAG_NAME +") VALUES (1,'Pizza')");
        db.execSQL("INSERT INTO " + TABLE_TAG + "(" + COLUMN_TAG_ID + ","+ COLUMN_TAG_NAME +") VALUES (2,'Pancakes')");
        db.execSQL("INSERT INTO " + TABLE_TAG + "(" + COLUMN_TAG_ID + ","+ COLUMN_TAG_NAME +") VALUES (3,'Grill')");
        db.execSQL("INSERT INTO " + TABLE_TAG + "(" + COLUMN_TAG_ID + ","+ COLUMN_TAG_NAME +") VALUES (4,'Burger')");
        db.execSQL("INSERT INTO " + TABLE_TAG + "(" + COLUMN_TAG_ID + ","+ COLUMN_TAG_NAME +") VALUES (5,'Pasta')");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEALS);
        onCreate(db);
    }


    public List<Meal> getAllMealById(int res_id){
        List<Meal> meals = new ArrayList<>();
        String RESTAURANT_SELECT_QUERY = "Select * FROM " + TABLE_MEALS + " WHERE " + COLUMN_ID_RESTORANA + "=" + res_id;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANT_SELECT_QUERY, null);

        try {
            if(cursor.moveToFirst()){
                do {
                    Meal m = new Meal();
                    int id = m.getId();
                    String name = m.getName();
                    String desc = m.getDescription();
                    double price = m.getPrice();



                    id = cursor.getInt(cursor.getColumnIndex(COLUMN_MEAL_ID));
                    name = cursor.getString(cursor.getColumnIndex(COLUMN_MEAL_NAME));
                    desc = cursor.getString(cursor.getColumnIndex(COLUMN_MEAL_DESCRIPTION));
                    price = cursor.getDouble(cursor.getColumnIndex(COLUMN_MEAL_PRICE));


                    m.setId(id);
                    m.setName(name);
                    m.setDescription(desc);
                    m.setPrice(price);


                    meals.add(m);
                }while (cursor.moveToNext());

            }
        }catch (Exception e){
            Log.d("Select", "Error database");
        }finally {
            if (cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
        return meals;
    }

}