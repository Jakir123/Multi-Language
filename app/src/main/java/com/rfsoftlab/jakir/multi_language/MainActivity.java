package com.rfsoftlab.jakir.multi_language;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener {

    private RecyclerView rcvContact;
    private ArrayList<Contact_Model> contactModels;
    private Contact_Model contactModel;
    private Contact_Adapter contactAdapter;

    private Locale myLocale;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences=getSharedPreferences("ContactList", Context.MODE_PRIVATE);
        String lang=sharedPreferences.getString("lang","");
        if (lang.equalsIgnoreCase("")){

        }else {
            setLocale(lang);
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(MainActivity.this, "onCreate!", Toast.LENGTH_SHORT).show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        initializations();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String name = extras.getString("name");
            String phone = extras.getString("phone");

            contactModel = new Contact_Model(name, phone);
            contactModels.add(contactModel);

        }

        contactAdapter = new Contact_Adapter(this, contactModels);
        rcvContact.setAdapter(contactAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddNewActivity = new Intent(MainActivity.this, AddNewActivity.class);
                startAddNewActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startAddNewActivity);
            }
        });
    }

    private void initializations() {
        rcvContact = (RecyclerView) findViewById(R.id.rvPersonInfo);
        rcvContact.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rcvContact.setLayoutManager(llm);

        contactModels = new ArrayList<>();

    }

    @Override
    public void onItemClick(View childView, int position) {

    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

    @Override
    public void onItemDoubleTap(View childView, int position) {

    }

    @Override
    public void onItemDownTap(View childView, int position) {

    }

    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

}
