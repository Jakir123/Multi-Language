package com.rfsoftlab.jakir.multi_language;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNewActivity extends AppCompatActivity {

    private Button btnAddNew;
    private EditText etName;
    private EditText etPhone;

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

                String name=etName.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();

                Intent gotoMainActivity=new Intent(AddNewActivity.this,MainActivity.class);
                gotoMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                gotoMainActivity.putExtra("name",name);
                gotoMainActivity.putExtra("phone",phone);
                startActivity(gotoMainActivity);
                finish();
            }
        });
    }

    private void initializations() {
        etName= (EditText) findViewById(R.id.etName);
        etPhone= (EditText) findViewById(R.id.etPhone);
        btnAddNew= (Button) findViewById(R.id.btnAddNew);
    }

}
