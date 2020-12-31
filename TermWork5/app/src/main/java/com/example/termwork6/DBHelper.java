package com.example.termwork6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNT_TABLE = "CREATE TABLE ACCOUNT(NAME VARCHAR(20),PIN INTEGER)";
        db.execSQL(CREATE_ACCOUNT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ACCOUNT");
        onCreate(db);
    }
    public String addAccount(String name, int pin){
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("PIN",pin);
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert("ACCOUNT",null, values);
        db.close();
        return "Inserted Successfully";
    }

    public int getPin(){
        String query="SELECT PIN FROM ACCOUNT";
        SQLiteDatabase db=this.getReadableDatabase();
        try(Cursor cursor = db.rawQuery(query,null)){
            if(cursor.moveToFirst()){
                db.close();
                return cursor.getInt(0);
            }
            else{
                db.close();
                return 0;
            }
        }

    }
}
