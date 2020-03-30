package com.example.hw131;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = PressureActivity.class.getSimpleName();
    private EditText editTxtSurname;
    private EditText editTxtName;
    private EditText editTxtMiddleName;
    private Button saveBtn;
    private String[] age;
    private Button vitalsBtn;
    private Button pressureBtn;
    Spinner spnAge;
    private static  final int REQUEST_ACCESS_TYPE=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, age);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spnAge.setAdapter(adapter);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "save button clicked");
                String surname = editTxtSurname.getText().toString();
                String name = editTxtName.getText().toString();
                String middleName = editTxtMiddleName.getText().toString();
                String age = (String) spnAge.getSelectedItem();
              FullName fullName = new FullName(name, surname, middleName, age);
            }
        });

        pressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "pressure button clicked");
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                String surname = editTxtSurname.getText().toString();
                String name = editTxtName.getText().toString();
                String middleName = editTxtMiddleName.getText().toString();
                String age = (String) spnAge.getSelectedItem();
                FullName fullName = new FullName(name, surname, middleName, age);
                intent.putExtra(FullName.class.getSimpleName(), fullName);
                startActivity(intent);
            }
        });


        vitalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "vitals button clicked");
                Intent intent = new Intent(MainActivity.this, VitalsActivity.class);
                String surname = editTxtSurname.getText().toString();
                String name = editTxtName.getText().toString();
                String middleName = editTxtMiddleName.getText().toString();
                String age = (String) spnAge.getSelectedItem();
                FullName fullName = new FullName(name, surname, middleName, age);
                intent.putExtra(FullName.class.getSimpleName(), fullName);
                startActivity(intent);
            }
        });
    }

    private void init() {
        Log.d(TAG, "initialized");
        editTxtSurname = (EditText) findViewById(R.id.edtTxtSurname);
        editTxtName = (EditText) findViewById(R.id.edtTxtName);
        editTxtMiddleName = (EditText) findViewById(R.id.edtTxtMiddleName);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        vitalsBtn = (Button) findViewById(R.id.vitalsBtn);
        pressureBtn = (Button) findViewById(R.id.pressureBtn);
        age = new String[105];
        for (int i = 0; i < age.length; i++) {
            age[i] = String.valueOf(i + 1);
        }
        spnAge = (Spinner) findViewById(R.id.age);
    }
}
