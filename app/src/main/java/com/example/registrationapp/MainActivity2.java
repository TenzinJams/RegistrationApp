package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText FName,LName,StdID,Programme,AcedamicYear,Semester,Year;
    TextView Module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FName=(EditText) findViewById(R.id.fName);
        LName=(EditText) findViewById(R.id.lName);
        StdID=(EditText) findViewById(R.id.IndexNo);
        Programme=(EditText) findViewById(R.id.Programme);
        AcedamicYear=(EditText) findViewById(R.id.AcademicYear);
        Semester=(EditText) findViewById(R.id.Semester);
        Year=(EditText) findViewById(R.id.Year);
        Module=(TextView) findViewById(R.id.Module);

        FName.setText(getIntent().getStringExtra("fname"));
        LName.setText(getIntent().getStringExtra("lname"));
        StdID.setText(getIntent().getStringExtra("index"));
        Programme.setText(getIntent().getStringExtra("programme"));
        AcedamicYear.setText(getIntent().getStringExtra("academicyear"));
        Semester.setText(getIntent().getStringExtra("semestar"));
        Year.setText(getIntent().getStringExtra("year"));
        Module.setText(getIntent().getStringExtra("module"));
    }
}