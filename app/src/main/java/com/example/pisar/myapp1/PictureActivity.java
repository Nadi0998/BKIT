package com.example.pisar.myapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        String imgPath = getIntent().getStringExtra("kek");
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setImageResource(getResources().getIdentifier(imgPath, "drawable", getPackageName()));
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(getIntent().getStringExtra("inton"));
    }
    public  void  onclick(View v){
        PictureActivity.this.finish();
    }
}
