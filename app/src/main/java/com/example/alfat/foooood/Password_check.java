package com.example.alfat.foooood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Password_check extends AppCompatActivity {
EditText password;
    Button next;
    DatabaseHelper dat;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_check);
        password=(EditText)findViewById(R.id.editText5);
        next=(Button)findViewById(R.id.button5);
        dat=new DatabaseHelper(this);
    }
    public void next(View view)
    {
        ArrayList<Student> employees = dat.getAllStudents();
        for (Student employee : employees) {
           pass=employee.getPhone();
        }
      //  Toast.makeText(getApplicationContext(),pass, Toast.LENGTH_SHORT).show();
       String a=password.getText().toString();
        if(a.equals(pass))
        {
            Intent intent = new Intent(Password_check.this, Main2Activity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Incorrect Password", Toast.LENGTH_SHORT).show();
        }

    }
}
