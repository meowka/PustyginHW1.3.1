package com.example.hw131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PressureActivity extends AppCompatActivity {
    private static final String TAG = PressureActivity.class.getSimpleName();
    private EditText edTxtUpper;
    private EditText edTxtLower;
    private EditText edTxtPulse;
    private CheckBox tachycardiaChBx;
    private TextView fullNameTxt;
    private Button menuBtn;
    private Button vitalsBtn;
    private Button saveBtn;
    private EditText edTxtDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

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
                String edtTxtUpper = edTxtUpper.getText().toString();
                String edtTxtLower = edTxtLower.getText().toString();
                String edtTxtPulse = edTxtPulse.getText().toString();
                boolean haveTachycardia = tachycardiaChBx.isChecked();
                String strTxtDate = edTxtDate.getText().toString();

                try {
                    int upper = Integer.parseInt(edtTxtUpper);
                    int lower = Integer.parseInt(edtTxtLower);
                    int pulse = Integer.parseInt(edtTxtPulse);


                    String result = "Верхнее давление: " + upper + " ,Нижнее давление: " + lower + " ,Пульс: " + pulse + " ,Тахикардия имеется: " + haveTachycardia + " ,Дата: " + strTxtDate;
                    Toast.makeText(PressureActivity.this,result,Toast.LENGTH_SHORT).show();
                    Pressure pressure = new Pressure(upper, lower, pulse, haveTachycardia, strTxtDate);
                    Pressure.p.add(pressure);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(PressureActivity.this, R.string.errorInfo, Toast.LENGTH_LONG).show();
                }
                finally {
                    edTxtUpper.getText().clear();
                    edTxtLower.getText().clear();
                    edTxtPulse.getText().clear();
                    tachycardiaChBx.setChecked(false);
                    edTxtDate.getText().clear();
                }
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "menu button clicked");
                Intent intent = new Intent(PressureActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        vitalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "vitals button clicked");
                Intent intent = new Intent(PressureActivity.this, VitalsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        Log.d(TAG, "initialized");
        edTxtUpper = (EditText) findViewById(R.id.edTxtUpper);
        edTxtLower = (EditText) findViewById(R.id.edTxtLower);
        edTxtPulse = (EditText) findViewById(R.id.edTxtPulse);
        tachycardiaChBx = (CheckBox) findViewById(R.id.tachycardiaChBx);
        fullNameTxt = (TextView) findViewById(R.id.fullNameTxt);
        menuBtn = (Button) findViewById(R.id.menuBtn);
        vitalsBtn = (Button) findViewById(R.id.vitalsBtn);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        edTxtDate = (EditText) findViewById(R.id.edtTxtDate);
    }
}
