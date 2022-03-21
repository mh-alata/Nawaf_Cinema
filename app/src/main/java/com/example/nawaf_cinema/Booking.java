package com.example.nawaf_cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends AppCompatActivity {
    double input;
    int number_of_Movies;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        final EditText num = (EditText) findViewById(R.id.editTextNumber);
        final TextView result = (TextView) findViewById(R.id.textView4);
        final Button confirm = (Button) findViewById(R.id.button);

        final CheckBox chk1 =(CheckBox) findViewById(R.id.check1);
        final CheckBox chk2 =(CheckBox) findViewById(R.id.check2);
        final CheckBox chk3 =(CheckBox) findViewById(R.id.check3);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input= Double.parseDouble(num.getText().toString());
                double price = 20* input;

                number_of_Movies=0;
                if(chk1.isChecked()) number_of_Movies++;
                if(chk2.isChecked()) number_of_Movies++;
                if(chk3.isChecked()) number_of_Movies++;
                price *= number_of_Movies;

                result.setText("Total Price is "+ price);


                if(number_of_Movies <=1 ) message ="You booked "+ number_of_Movies + " Movie";
                else message ="You booked "+ number_of_Movies + " Movies";
                Toast.makeText(Booking.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}