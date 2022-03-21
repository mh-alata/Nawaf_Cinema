package com.example.nawaf_cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Cartoon extends AppCompatActivity {

    Integer[] Movies = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04, R.drawable.pic05, R.drawable.pic06};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);

        GridView grid = (GridView) findViewById(R.id.gridView);
        pic = (ImageView) findViewById(R.id.imgV);
        grid.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;
        public ImageAdapter(Context cartoon){
            context = cartoon;
        }

        @Override
        public int getCount() {
            return Movies.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic= new ImageView(context);
            pic.setImageResource(Movies[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(500,500));
            return pic;
        }
    }
}