package com.example.willyg.app0130_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SQLite.db";
    private static final int DATABASE_VERSION = 1;
    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase arg0) {
// TODO Auto-generated method stub
        arg0.execSQL("CREATE TABLE table1 (Name TEXT,Height TEXT,Weight TEXT,BMI TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub
        arg0.execSQL("DROP TABLE IF EXISTS table1");
    }
}
