package com.example.grouptripexpensetracker;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=(EditText)findViewById(R.id.editText);
        et1.setText(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.trips)
        {
            Intent i = new Intent(this, TripsList.class);
            startActivity(i);
        }
        else if(id==R.id.addexpense)
        {
            Intent i=new Intent(this,TripsList.class);
            i.putExtra("Add","AddExpense");
            startActivity(i);
        }
        else if(id==R.id.day)
        {
            Intent i=new Intent(this,TripsList2.class);
            startActivity(i);
        }
        else if(id==R.id.category)
        {
            Intent i=new Intent(this,TripsList3.class);
            startActivity(i);
        }
        else if(id==R.id.trip)
        {
            Intent i=new Intent(this,TripsList1.class);
            startActivity(i);
        }
        else if (id == R.id.exit)
        {
            System.exit(0);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
