package com.rfsoftlab.jakir.multi_language;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class AddNewActivity extends AppCompatActivity {

    private Button btnAddNew;
    private EditText etName;
    private EditText etPhone;

    private Locale myLocale;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        

        initializations();
        clickListener();

    }

    private void clickListener() {
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                Intent gotoMainActivity = new Intent(AddNewActivity.this, MainActivity.class);
                gotoMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                gotoMainActivity.putExtra("name", name);
                gotoMainActivity.putExtra("phone", phone);
                startActivity(gotoMainActivity);
                finish();
            }
        });
    }

    private void initializations() {
        etName= (EditText) findViewById(R.id.etName);
        etPhone= (EditText) findViewById(R.id.etPhone);
        btnAddNew= (Button) findViewById(R.id.btnAddNew);

        sharedPreferences=getSharedPreferences("ContactList", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case R.id.english:
                setLocale("en");
                Toast.makeText(AddNewActivity.this, "You have selected English!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bangla:
                setLocale("bn");
                Toast.makeText(AddNewActivity.this, "You have selected Bangla!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.japanese:
                setLocale("ja");
                Toast.makeText(AddNewActivity.this, "You have selected Japanese", Toast.LENGTH_SHORT).show();
                break;
            case R.id.french:
                setLocale("fr");
                Toast.makeText(AddNewActivity.this, "You have selected French!", Toast.LENGTH_SHORT).show();
                break;
            default:
                setLocale("en");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String lang) {
        editor.putString("lang", lang);
        editor.commit();

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        recreate();
    }
}
