package com.example.alertzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin extends AppCompatActivity {
    DatabaseReference ref;
    MyCity myCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        final EditText latitude = (EditText)findViewById(R.id.lat);
        final EditText longitude = (EditText)findViewById(R.id.lng);
        Button btn = (Button)findViewById(R.id.submit);
        Button back = (Button)findViewById(R.id.back);
        ref = FirebaseDatabase.getInstance().getReference("dangerArea").child("MyCity");
        myCity = new MyCity();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin.this,login.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat = Double.parseDouble(latitude.getText().toString().trim());
                double lomg = Double.parseDouble(longitude.getText().toString().trim());
            myCity.setLatitude(lat);
            myCity.setLongitude(lomg);
            ref.push().setValue(myCity);
                Toast.makeText(Admin.this,"Entered Successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
