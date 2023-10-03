package com.example.rapidez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Showaccl_data extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference xaxiref,yaxisref;
    private TextView AcclnXaxis,AcclnYaxis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showaccl_data);
        AcclnXaxis=findViewById(R.id.acclnXtxt);
        AcclnYaxis=findViewById(R.id.acclnYtxt);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("newRequest");
        firebaseDatabase = FirebaseDatabase.getInstance();
        xaxiref=firebaseDatabase.getReference("A");
        yaxisref=firebaseDatabase.getReference("Y");
        getdata();
    }

    private void getdata() {
        xaxiref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                float value = snapshot.getValue(float.class);
                String value1=Float.toString(value);
                // after getting the value we are setting
                // our value to our text view in below line.
                AcclnXaxis.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(Showaccl_data.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        yaxisref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                float value = snapshot.getValue(float.class);
                String value1=Float.toString(value);
                // after getting the value we are setting
                // our value to our text view in below line.
                AcclnYaxis.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(Showaccl_data.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}