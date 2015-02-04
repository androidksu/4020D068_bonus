package com.example.willyg.app0130_sql;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    EditText name, height, weight;
    TextView tv;

    SQLiteDatabase db;
    SQLite dbHelper;
    String DATABASE_TABLE = "table1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText1);
        height = (EditText) findViewById(R.id.editText2);
        weight = (EditText) findViewById(R.id.editText3);
        tv = (TextView) findViewById(R.id.textView4);
    }

    // 新增
    public void bt1(View v) {
        String name1 = name.getText().toString();
        String height1 = height.getText().toString();
        String weight1 = weight.getText().toString();
        double newheight =  Double.parseDouble(height1) /100;
        double newweight =  Double.parseDouble(weight1);
        double BMI = newweight / (newheight * newheight);
        // 開啟資料庫
        dbHelper = new SQLite(getBaseContext());
        db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("Name", name1);
        cv.put("height", height1);
        cv.put("weight", weight1);
        cv.put("BMI", BMI);
        db.insert(DATABASE_TABLE, null, cv);
        //關閉資料庫
        dbHelper.close();
        db.close();
        tv.setText("Add a data");
    }

    // 查詢
    public void bt2(View v) {
        String[] item = {"Name", "Height", "Weight", "BMI"};
        StringBuffer sb = new StringBuffer();
        sb.append("Name");
        sb.append("\t\t\t\t");
        sb.append("Height");
        sb.append("\t\t\t");
        sb.append("Weight");
        sb.append("\t\t\t");
        sb.append("BMI");
        sb.append("\n");

        // 開起資料庫
        dbHelper = new SQLite(getBaseContext());
        db = dbHelper.getWritableDatabase();
        // 查詢
        Cursor c = db.query(DATABASE_TABLE, item, null, null, null, null, null);
        c.moveToFirst();

        for (int i = 0; i < c.getCount(); i++) {
            sb.append(c.getString(0));
            sb.append("\t\t\t\t\t\t");
            sb.append(c.getString(1));
            sb.append("\t\t\t\t\t\t\t");
            sb.append(c.getString(2));
            sb.append("\t\t\t\t\t");
            sb.append(c.getString(3));
            sb.append("\n");
            c.moveToNext();
        }
        //關閉資料庫
        dbHelper.close();
        db.close();
        tv.setText(sb);
    }
}
