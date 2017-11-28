package com.example.alfat.foooood;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    Button N,C;
    DatabaseHelper dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        N=(Button)findViewById(R.id.button2);
        C=(Button)findViewById(R.id.button3);
        dat=new DatabaseHelper(this);
    }
    public  void  Coustomer(View view)
    {
        try
        {Intent intent = new Intent(MainActivity.this, Foooood.class);
        startActivity(intent);}
        catch (Exception e)
        {
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void New_iteam(View view)
    {
        ArrayList<Student> employees = dat.getAllStudents();
        if (employees != null && employees.size() > 0)
        {
            Intent intent = new Intent(MainActivity.this, Password_check.class);
            startActivity(intent);
        }
        else
        { Intent intent = new Intent(MainActivity.this, Passward.class);
        startActivity(intent);}
    }

}
