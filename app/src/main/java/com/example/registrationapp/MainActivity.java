package com.example.registrationapp;

import static android.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] programmelist={"Architecture","IT","Civil","ECE","ICE","Geology","Electrical"};
    String[] yearlist={"First","Second","Third","Fourth","Fifth"};
    Spinner programmeSpinner,yearSpinner;
    EditText fNameIn,lNameIn,StdIDIn,AcademicYearIn;
    String module="";
    Button submit;
    RadioButton Sem;
    RadioGroup RG;
    CheckBox cte205,cte206,cte207,cte208,dis302;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        programmeSpinner=(Spinner) findViewById(R.id.PSpinner);
        yearSpinner=(Spinner) findViewById(R.id.YSpinner);

        ArrayAdapter<String> programmeAdapter = new ArrayAdapter<String>(this, simple_spinner_item,programmelist);
        programmeAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
        programmeSpinner.setAdapter(programmeAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, simple_spinner_item,yearlist);
        yearAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        fNameIn=(EditText) findViewById(R.id.fName);
        lNameIn=(EditText) findViewById(R.id.lName);
        StdIDIn=(EditText) findViewById(R.id.indexNo);
        AcademicYearIn=(EditText) findViewById(R.id.AcademicYear);
        RG=(RadioGroup) findViewById(R.id.RG);
        submit=(Button) findViewById(R.id.Submit);
        cte205=(CheckBox) findViewById(R.id.CTE205);
        cte206=(CheckBox) findViewById(R.id.CTE206);
        cte207=(CheckBox) findViewById(R.id.CTE207);
        cte208=(CheckBox) findViewById(R.id.CTE208);
        dis302=(CheckBox) findViewById(R.id.DIS302);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("fname",fNameIn.getText().toString());
                intent.putExtra("lname",lNameIn.getText().toString());
                intent.putExtra("index",StdIDIn.getText().toString());
                intent.putExtra("academicyear",AcademicYearIn.getText().toString());
                intent.putExtra("programme",programmeSpinner.getSelectedItem().toString());
                intent.putExtra("year",yearSpinner.getSelectedItem().toString());
                Sem=findViewById(RG.getCheckedRadioButtonId());
                intent.putExtra("semestar",Sem.getText().toString());

                if(cte205.isChecked())
                {
                    module+="CTE205"+"\n";
                }
                if(cte206.isChecked())
                {
                    module+="CTE206"+"\n";
                }
                if(cte207.isChecked())
                {
                    module+="CTE207"+"\n";
                }
                if(cte208.isChecked())
                {
                    module+="CTE208"+"\n";
                }
                if(dis302.isChecked())
                {
                    module+="DIS302"+"\n";
                }

                intent.putExtra("module",module);

                startActivity(intent);

            }
        });
    }
}