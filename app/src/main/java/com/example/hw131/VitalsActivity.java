package com.example.hw131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VitalsActivity extends AppCompatActivity {

    private static final String TAG = VitalsActivity.class.getSimpleName();
    private TextView fullNameTxt;
    private EditText edtTxtWeight;
    private EditText edtTxtSteps;
    private Button saveBtn;
    private Button menuBtn;
    private Button pressureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);

        init();
        fullNameTxt.setTextSize(18);
        fullNameTxt.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        final FullName fullName;
        if (arguments != null) {
            fullName = (FullName) arguments.getSerializable(FullName.class.getSimpleName());
            fullNameTxt.setText(fullName.getSurname() + " " + fullName.getName() + " " + fullName.getMiddleName() + ", Возраст: " + fullName.getAge());
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "save button clicked");
                String strSteps = edtTxtSteps.getText().toString();
                String strWeight = edtTxtWeight.getText().toString();

                try {
                    int steps = Integer.parseInt(strSteps);
                    float weight = Float.parseFloat(strWeight);
                    String result = "Вес " + weight + " ,Количество шагов " + steps;
                    Toast.makeText(VitalsActivity.this, result, Toast.LENGTH_SHORT).show();
                    Vitals vitals = new Vitals(weight, steps);
                    Vitals.v.add(vitals);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(VitalsActivity.this, R.string.errorInfo, Toast.LENGTH_LONG).show();
                } finally {
                    edtTxtSteps.getText().clear();
                    edtTxtWeight.getText().clear();
                }
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "clicked menuBtn");
                Intent intent = new Intent(VitalsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        pressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "clicked pressureBtn");
                Intent intent = new Intent(VitalsActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        fullNameTxt = (TextView) findViewById(R.id.fullNameTxt);
        edtTxtWeight = (EditText) findViewById(R.id.edtTxtWeight);
        edtTxtSteps = (EditText) findViewById(R.id.edtTxtSteps);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        menuBtn = (Button) findViewById(R.id.menuBtn);
        pressureBtn = (Button) findViewById(R.id.pressureBtn);
        Log.d(TAG, "initialized");
    }
}
