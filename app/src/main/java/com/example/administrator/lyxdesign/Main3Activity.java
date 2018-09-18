package com.example.administrator.lyxdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,View.OnTouchListener{
    private Button ac3_bt1;
    private  Button ac3_bt2;
    private  int value=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ac3_bt1=(Button)findViewById(R.id.ac3_bt1);
        ac3_bt2=(Button)findViewById(R.id.ac3_bt2);
        ac3_bt1.setOnClickListener(this);
        ac3_bt2.setOnClickListener(this);
        ac3_bt2.setOnTouchListener(this);
    }
    public void onClick(View view){
        Button btn=(Button) view;
        int screenW=getWindow().getWindowManager().getDefaultDisplay().getWidth();
        if(value==1&&btn.getWidth()>screenW-100){
            value=-1;
        }else if(value==-1&&btn.getWidth()<300){
            value=1;
        }
        btn.setWidth(btn.getWidth()+(int)(btn.getWidth()*0.1*value));
        btn.setHeight(btn.getHeight()+(int)(btn.getHeight()*0.1*value));
    }
    public boolean onTouch(View view, MotionEvent motionEvent){
        int action=motionEvent.getAction();
        if(action==MotionEvent.ACTION_DOWN){
            view.setBackgroundResource(R.drawable.la2);
        }else if(action==MotionEvent.ACTION_UP){
            view.setBackgroundResource(R.drawable.la1);
        }
        return false;
    }
}
