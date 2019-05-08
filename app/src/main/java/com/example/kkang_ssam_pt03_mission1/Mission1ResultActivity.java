package com.example.kkang_ssam_pt03_mission1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Mission1ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView nameView=(TextView)findViewById(R.id.read_name);
        TextView phoneView=(TextView)findViewById(R.id.read_phone);
        TextView emailView=(TextView)findViewById(R.id.read_email);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select name, phone, email from tb_contact order by _id desc limit 1", null);

        while(cursor.moveToNext()){
            nameView.setText(cursor.getString(0));
            phoneView.setText(cursor.getString(1));
            emailView.setText(cursor.getString(2));
        }
        db.close();
    }
}
