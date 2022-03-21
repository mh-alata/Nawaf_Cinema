package com.example.nawaf_cinema;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        //String[] attraction = {"Kids Cartoons","Book Tickets","Movie Rating", "Visit Us"};
        String[] attraction = getResources().getStringArray(R.array.mainList);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.text,attraction));

    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        switch (position){
            case 0:
                startActivity(new Intent(MainActivity.this, Cartoon.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Booking.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Rating.class));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thelunacinema.com/")));
                break;
        }
    }
}