package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText etcad, etusd;
    Button btnconvert,btnclear;
    Spinner curspin;
    double result;
    double[] rateList = {0.75, 0.68, 1.11, 53.88};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etcad = findViewById(R.id.cad);
        etusd = findViewById(R.id.usd);
        curspin = findViewById(R.id.currencyspinner);

        btnconvert = findViewById(R.id.convert);
        btnclear=findViewById(R.id.clearbutton);

        btnconvert.setOnClickListener(this);
        btnclear.setOnClickListener(this);

        List<String> currency = new ArrayList<String>();
        currency.add("USD");
        currency.add("EUR");
        currency.add("AUS");
        currency.add("INR");


        ArrayAdapter<String> curAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, currency);


        curAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        curspin.setAdapter(curAdapter);
        curspin.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clearbutton:
                etcad.setText("");
                etusd.setText("");

                break;
            case R.id.convert:
            Double Amt = new Double(result);
            etusd.setText(Amt.toString());
            result=0.0;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (etcad.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter the amount in CAD...!", Toast.LENGTH_LONG).show();
        } else {

            double cad = Double.parseDouble(etcad.getText().toString());
            double amt = cad * rateList[position];
            result = amt;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
