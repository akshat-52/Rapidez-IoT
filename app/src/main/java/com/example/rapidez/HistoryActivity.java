package com.example.rapidez;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistoryActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ratingref;
    private TextView ratingtxt,rating2txt,rating3txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ratingtxt=findViewById(R.id.rating1txt);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("newRequest");
        firebaseDatabase = FirebaseDatabase.getInstance();
        ratingref=firebaseDatabase.getReference("S");
        getRating();
    }

    private void getRating() {
        ratingref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                float value = 40;//snapshot.getValue(float.class);
                if(value<=10){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("1 Star");
                }
                if(value>=10&& value<=20){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("1.5 Star");
                }
                if(value>=20&& value<=30){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("2 Star");
                }
                if(value>=30&& value<=40){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("2.5 Star");
                }
                if(value>=40&& value<=50){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("3 Star");
                }
                if(value>=50&& value<=60){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("3.5 Star");
                }
                if(value>=60&& value<=70){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("4 Star");
                }
                if(value>=70&& value<=80){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("4.5 Star");
                }
                if(value>=80&& value<=90){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("4.7 Star");
                }
                if(value>=90&& value<=100){
                    String value1=Float.toString(value);
                    // after getting the value we are setting
                    // our value to our text view in below line.
                    ratingtxt.setText("5 Star");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(HistoryActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}