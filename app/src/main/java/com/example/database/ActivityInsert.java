package com.example.database;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class ActivityInsert extends AppCompatActivity {
    EditText id,name,salary;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        btn = findViewById(R.id.insert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean add = new DBHelper(getApplicationContext()).addData(id.getText().toString(),name.getText().toString(),Double.parseDouble(salary.getText().toString()));
                if(add == true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Added Data", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}