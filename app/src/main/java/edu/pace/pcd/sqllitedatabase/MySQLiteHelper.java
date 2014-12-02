package edu.pace.pcd.sqllitedatabase;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_POSITIONS = "POSITIONOFPHONE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_POSITION = "Directions";

    private static final String DATABASE_NAME = "positions.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_POSITIONS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_POSITION
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSITIONS);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


}// END OF CLASS
