package com.example.administrator.lyxdesign;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity implements TimePicker.OnTimeChangedListener {
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        timePicker=(TimePicker)findViewById(R.id.mytime);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);

    }


    @Override
    public void onTimeChanged(TimePicker timePicker,int i,int i1){
        Toast.makeText(Main5Activity.this,"时间改变："+i+"点"+i1+"分",Toast.LENGTH_SHORT).show();
    }
}
