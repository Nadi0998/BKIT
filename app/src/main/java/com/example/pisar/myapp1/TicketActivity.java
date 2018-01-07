package com.example.pisar.myapp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class TicketActivity extends AppCompatActivity {
    private final String FILENAME = "file";
    private final String LOG_TAG = "This is log";
    private ArrayList <TicketClass> tc = new ArrayList<TicketClass>(10);
    int NumAns=0;
    int IdPressBut= -1;
    int RightId= -1;
    RadioButton[] arrrb= new RadioButton[4];

    public void onCreate(Bundle saved){
    super.onCreate(saved);
    setContentView(R.layout.activity_ticket);
    arrrb[0] = (RadioButton) findViewById(R.id.ticketVar1);
    arrrb[1] = (RadioButton) findViewById(R.id.ticketVar2);
    arrrb[2] = (RadioButton) findViewById(R.id.ticketVar3);
    arrrb[3] = (RadioButton) findViewById(R.id.ticketVar4);
    int ticketnumber = getIntent().getIntExtra("num",0);
    try{
        XmlPullParser xpp = getResources().getXml(R.xml.tickets);
        while (xpp.getEventType() !=XmlPullParser.END_DOCUMENT) {
            if(xpp.getEventType()==XmlPullParser.START_TAG && xpp.getName().equals("task")){
                tc.add(new TicketClass(new String[]{xpp.getAttributeValue(null, "number"), xpp.getAttributeValue(null, "file_name"),  xpp.getAttributeValue(null, "quest"), xpp.getAttributeValue(null, "right_answer"), xpp.getAttributeValue(null,"other1"),
                        xpp.getAttributeValue(null, "other2"), xpp.getAttributeValue(null, "other3"), xpp.getAttributeValue(null, "clarification")}));
            }
            xpp.next();
        }
    }
    catch (Throwable e){
        Snackbar.make(findViewById(R.id.lol), "bug"+e.toString(), Snackbar.LENGTH_LONG).show();
    }
   PrintAns();


}
    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()){
                case R.id.ticketVar1: IdPressBut=0;
                    break;
                case R.id.ticketVar2: IdPressBut=1;
                    break;
                case R.id.ticketVar3: IdPressBut=2;
                    break;
                case R.id.ticketVar4: IdPressBut=3;
                    break;
            }
        }
    };

    public void onclick(View v) {
        Intent nt  = new Intent(TicketActivity.this, PictureActivity.class);
        nt.putExtra("kek",tc.get(NumAns).clar);
        if(IdPressBut==RightId){
            nt.putExtra("inton", "Правильный ответ");
        }
        else{
            nt.putExtra("inton", "Неправильный ответ");
        }
        startActivity(nt);
        NumAns++;
        PrintAns();

    }
    public void PrintAns(){
        TextView tv = (TextView) findViewById(R.id.ticketText);
        ImageView iv = (ImageView) findViewById(R.id.ticketImage);

        Button bt = (Button) findViewById(R.id.button2);
        tv.setText((NumAns+1)+tc.get(NumAns).quest);
        iv.setImageResource(getResources().getIdentifier(tc.get(NumAns).ill, "drawable", getPackageName()));
        answerset as = tc.get(NumAns).getansset();
        RightId =  as.id;
        for(int i=0; i<4; i++){
            arrrb[i].setText(as.str[i]);
        }

    }

}
