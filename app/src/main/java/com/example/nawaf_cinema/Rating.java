package com.example.nawaf_cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    public static MediaPlayer mediaPlayer;
    private Spinner spinner;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        final ImageView stop = (ImageView) findViewById(R.id.imgStop);
        mediaPlayer = MediaPlayer.create(this, R.raw.bang);

        //mediaPlayer.setAudioStreamType(R.raw.bang);

        mediaPlayer.start();
        playing=1;

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playing == 1)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;
                    playing=0;
                }
                else{
                    mediaPlayer =  MediaPlayer.create(Rating.this, R.raw.bang);

                    mediaPlayer.start();
                    playing=1;
                }
            }
        });

        spinner= (Spinner) findViewById(R.id.spinMovie);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.moviesList, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button save = (Button) findViewById(R.id.btnSave);
        RadioButton rd_Good = (RadioButton) findViewById(R.id.rdGood);
        RadioButton rd_Average = (RadioButton) findViewById(R.id.rdAverage);
        RadioButton rd_Bad = (RadioButton) findViewById(R.id.rdBad);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg="Please Rate The Movie";
                if(rd_Good.isChecked()){
                    msg="You Picked Good";
                }
                else if(rd_Average.isChecked()){
                    msg="You Picked Average";
                }
                else if(rd_Bad.isChecked()){
                    msg="You Picked Bad";
                }
                Toast.makeText(Rating.this, msg, Toast.LENGTH_SHORT).show();

            }
        });


    }
}