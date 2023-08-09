package com.example.grouptripexpensetracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et1.setText(null);
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);

    }
    public void travel(View v)
    {
        String s=et1.getText().toString();
        if(s.equals(null) || s.equals(""))
        {
            Toast.makeText(this,"Enter The Title of Journey",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i=new Intent(this,NewTrips.class);
            i.putExtra("title",s);
            startActivity(i);
        }
    }
}
