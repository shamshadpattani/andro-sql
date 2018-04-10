package com.example.admin.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Databaseconn db;
EditText e1,e2,e3;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.roll);
        e2=findViewById(R.id.name);
        e3=findViewById(R.id.mark);
        db=new Databaseconn(this);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals(" ") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "field are empty", Toast.LENGTH_SHORT).show();
                } else if (s1 != null || s2 != null || e3.getText() != null) {
                    boolean ins = db.insert(s1, s2, s3);
                    System.out.print(ins);
                    if (ins == true) {
                        Toast.makeText(getApplicationContext(), "Register succesfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "  unsuccesfully", Toast.LENGTH_SHORT).show();
                    }
                }
                    else
                     {
                         Toast.makeText(getApplicationContext(), "Registerd  unsuccesfully", Toast.LENGTH_SHORT).show();
                     }

            }
        });
    }
}
