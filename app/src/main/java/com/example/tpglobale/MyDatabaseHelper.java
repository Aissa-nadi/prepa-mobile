package com.example.tpglobale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Car_Manager";

    // Table name: Note.
    private static final String TABLE_Car = "Car";

    private static final String COLUMN_Car_ID ="Car_Id";
    private static final String COLUMN_Car_TITLE ="Car_Title";
    private static final String COLUMN_Car_CONTENT = "Car_Desc";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Script.
        String script = "CREATE TABLE " + TABLE_Car + "("
                + COLUMN_Car_ID + " INTEGER PRIMARY KEY," + COLUMN_Car_TITLE + " TEXT,"
                + COLUMN_Car_CONTENT + " TEXT" + ")";
        // Execute Script.
        db.execSQL(script);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Car);

        // Create tables again
        onCreate(db);
    }


    public int getCarsCount() {

        String countQuery = "SELECT  * FROM " + TABLE_Car;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


    // default, Insert 2 records.
    public void createDefaultCarsIfNeed()  {
        int count = this.getCarsCount();
        if(count ==0 ) {

            Car car = new Car("BMW","Description BMW");
            Car car2 = new Car("BMW","Description BMW");

            this.addCar(car);
            this.addCar(car2);
        }
    }


    public void addCar(Car car) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_Car_TITLE, car.getTitre());
        values.put(COLUMN_Car_CONTENT, car.getDesc());

        // Inserting Row
        db.insert(TABLE_Car, null, values);

        // Closing database connection
        db.close();
    }

    public int updateCar(Car car) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_Car_TITLE, car.getTitre());
        values.put(COLUMN_Car_CONTENT, car.getDesc());

        // updating row
        return db.update(TABLE_Car, values, COLUMN_Car_ID + " = ?",
                new String[]{String.valueOf(car.getImage())});
    }

    public void deleteCar(Car car) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Car, COLUMN_Car_ID + " = ?",
                new String[] { String.valueOf(car.getImage()) });
        db.close();
    }



    public Car getCar(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Car, new String[] { COLUMN_Car_ID,
                        COLUMN_Car_TITLE, COLUMN_Car_CONTENT }, COLUMN_Car_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Car car = new Car(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return note
        return car;
    }


    public List<Car> getAllCars() {

        List<Car> carList = new ArrayList<Car>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Car;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Car car = new Car();
                car.setImage(Integer.parseInt(cursor.getString(0)));
                car.setTitre(cursor.getString(1));
                car.setDesc(cursor.getString(2));

                // Adding note to list
                carList.add(car);
            } while (cursor.moveToNext());
        }

        // return note list
        return carList;
    }


}
