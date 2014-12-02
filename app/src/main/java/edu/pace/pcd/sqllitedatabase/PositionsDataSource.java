package edu.pace.pcd.sqllitedatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PositionsDataSource {

    private SQLiteDatabase DB;
    private MySQLiteHelper DBHelper;
    private String [] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_POSITION, MySQLiteHelper.TABLE_POSITIONS};
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " ;
    public PositionsDataSource(Context context){
        DBHelper= new MySQLiteHelper(context);
    }

    public void open() throws SQLException{
        DB =DBHelper.getWritableDatabase();
    }

    public void close(){
        DBHelper.close();
    }

    public Positions createPosition(String position){

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_POSITION, position);
        long insertID = DB.insert(MySQLiteHelper.TABLE_POSITIONS,null,values);
        Cursor cursor = DB.query(MySQLiteHelper.TABLE_POSITIONS,allColumns,MySQLiteHelper.COLUMN_ID + " = " + insertID,null,null,null,null);
        cursor.moveToFirst();
        Positions newPosition = cursorToPosition(cursor);
        cursor.close();
        return newPosition;

    }

    public List<Positions> getAllComments() {
        List<Positions> positions = new ArrayList<Positions>();

        Cursor cursor = DB.query(MySQLiteHelper.TABLE_POSITIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Positions position = cursorToPosition(cursor);
            positions.add(position);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return positions;
    }

    private Positions cursorToPosition(Cursor cursor) {
        Positions position = new Positions();
        position.setId(cursor.getLong(0));
        position.setPositions(cursor.getString(1));
        return position;
    }


    }


