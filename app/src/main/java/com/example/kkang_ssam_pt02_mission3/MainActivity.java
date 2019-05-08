package com.example.kkang_ssam_pt02_mission3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameView;
    EditText phoneView;
    EditText emailView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameView = (EditText)findViewById(R.id.add_name);
        phoneView = (EditText)findViewById(R.id.add_name);
        emailView = (EditText)findViewById(R.id.add_email);
        addBtn = (Button) findViewById(R.id.add_btn);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String name = nameView.getText().toString();
        String phone = phoneView.getText().toString();
        String email = emailView.getText().toString();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_contact (name, phone, email) values (?,?,?)",new String[]{name, phone, email});
        db.close();

        Intent intent= new Intent(this, Mission1ResultActivity.class);
        startActivity(intent);
    }

}
