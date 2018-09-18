package com.example.administrator.lyxdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.btdesign1);
        bt2=(Button)findViewById(R.id.btdesign2);
        bt3=(Button)findViewById(R.id.btdesign3);
        bt4=(Button)findViewById(R.id.btdesign4);
        bt5=(Button)findViewById(R.id.btdesign5);
        bt6=(Button)findViewById(R.id.btdesign6);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
    }
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btdesign1:
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btdesign2:
                intent.setClass(MainActivity.this, Main3Activity.class);
                startActivity(intent);
                break;
            case R.id.btdesign3:
                intent.setClass(MainActivity.this, Main4Activity.class);
                startActivity(intent);
                break;
            case R.id.btdesign4:
                intent.setClass(MainActivity.this, Main5Activity.class);
                startActivity(intent);
                break;
            case R.id.btdesign5:
                intent.setClass(MainActivity.this, Main6Activity.class);
                startActivity(intent);
                break;
            case R.id.btdesign6:
                intent.setClass(MainActivity.this, Main7Activity.class);
                startActivity(intent);
                break;
        }
    }
}
