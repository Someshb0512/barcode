package com.example.barcodescanner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FormFIll extends AppCompatActivity {
    DatabaseHelperEvents databaseHelperEvents;
    EditText ADM_bs;
    EditText ROOM_bs;
    EditText NAME_bs;
    EditText PHONE_bs;
    Button REGISTER_bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_fill);
        databaseHelperEvents = new DatabaseHelperEvents(this);
        databaseHelperEvents.createDatabase(databaseHelperEvents);
        ADM_bs = findViewById(R.id.ADM_bs);
        NAME_bs = findViewById(R.id.NAME_bs);
        ROOM_bs = findViewById(R.id.ROOM_bs);
        PHONE_bs = findViewById(R.id.PHONE_bs);
        REGISTER_bs = findViewById(R.id.REGISTER_bs);


    }
            public void formClick(View view){
                String admission = ADM_bs.getText().toString();
                String name = NAME_bs.getText().toString();
                String room = ROOM_bs.getText().toString();
                String phone = PHONE_bs.getText().toString();



                if (admission.isEmpty() || name.isEmpty() || room.isEmpty() || phone.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();



                    boolean insert = databaseHelperEvents.InsertEvent(admission , name ,room ,phone);
                    Toast.makeText(getApplicationContext() , "Checking", Toast.LENGTH_SHORT).show();
                    if (insert)
                    {
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                        ADM_bs.setText("");
                        NAME_bs.setText("");
                        ROOM_bs.setText("");
                        PHONE_bs.setText("");
                    } else {
                        Toast.makeText(FormFIll.this, "False.", Toast.LENGTH_SHORT).show();
                    }
                }



            }

        }





