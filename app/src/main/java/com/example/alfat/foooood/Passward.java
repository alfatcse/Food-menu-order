package com.example.alfat.foooood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Passward extends AppCompatActivity {
    EditText etpassword,etname,etphone;
    Button b;
    DatabaseHelper profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passward);
        etpassword=(EditText)findViewById(R.id.editText);
        etname=(EditText)findViewById(R.id.editText3);
        etphone=(EditText)findViewById(R.id.editText4);
        b=(Button)findViewById(R.id.button4);
        profile=new DatabaseHelper(this);
    }
    public void next(View view)
    {
        String name=etname.getText().toString();//name
        String phone=etphone.getText().toString();//id
        String password=etpassword.getText().toString();//phone
        String o="fgt";//parrent name
        Student prof=new Student(name,phone,password,o);
        Toast.makeText(getApplicationContext(), prof.toString(), Toast.LENGTH_LONG).show();
        long inserted =profile.insertEmployee(prof);
        if (inserted >= 0) {
            Toast.makeText(getApplicationContext(), "data_inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "data not inserted", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(Passward.this, Main2Activity.class);
        startActivity(intent);
     
    }
}
