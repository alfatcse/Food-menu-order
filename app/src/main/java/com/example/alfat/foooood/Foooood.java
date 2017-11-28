package com.example.alfat.foooood;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Foooood extends AppCompatActivity {
    GridView gridView;
    ArrayList<Food> list;
    ArrayList<String> list2;
    FoodListAdapter adapter = null;
    EditText ed;
    Button B;
    Spinner spinner2;
    EditText F;
    DatabaseHelper dat;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foooood);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        F=(EditText)findViewById(R.id.editText2);
        gridView = (GridView) findViewById(R.id.gridView);
        B = (Button) findViewById(R.id.button);
        dat=new DatabaseHelper(this);
        list = new ArrayList<>();
        list2=new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.food_items, list);
        gridView.setAdapter(adapter);
        // get all data from sqlite
        Cursor cursor = Main2Activity.sqLiteHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = "Name : "+cursor.getString(1);
            String price = "Price : "+cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            list2.add(name);
            list.add(new Food(name, price,image,id));
        }
        adapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list2);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter1);
    }
    public void or(View view)
    {
        ArrayList<Student> employees = dat.getAllStudents();
        for (Student employee : employees) {
            pass=employee.getID();
        }
        Toast.makeText(getApplicationContext(),pass, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Wait for a While.After being ready Your order Will be served ", Toast.LENGTH_SHORT).show();
        try {
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(pass,null, spinner2.getSelectedItem()+"  "+F.getText().toString(),null,null);
        }catch (Exception e){}
    }
}
