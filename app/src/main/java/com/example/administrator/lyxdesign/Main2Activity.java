package com.example.administrator.lyxdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private Spinner spin1;
    private  Spinner spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.inputtext);
        spin1=(Spinner)findViewById(R.id.spin1);
        spin2=(Spinner)findViewById(R.id.spin2);
        initspinner1();
        initspinner2();
        String[] str={"重庆交通大学","重庆工商大学","重庆西南大学","重庆师范大学","重庆大学","重庆重百","重庆杨家坪","重庆解放碑"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.down1,str);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
    private  void initspinner1()
    {
        String[] arr={"bj","sh"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
        spin1.setAdapter(arrayAdapter);
    }
    private void initspinner2()
    {
        List<Map<String,Object>> stumaps=new ArrayList<Map<String,Object>>();
        String[] names={"jake","josh","pew","smosh"};
        String[] majors={"Sport","Prank","Game","Soclal"};
        int[] images={R.drawable.jake,R.drawable.josh,R.drawable.pew,R.drawable.smosh};
        for (int i=0;i<names.length;i++)
        {
            Map<String,Object> m=new HashMap<String,Object>();
            m.put("icon",images[i]);
            m.put("name",names[i]);
            m.put("major",majors[i]);
            stumaps.add(m);
        }
        String[] key={"icon","name","major"};
        int[] value={R.id.usericon,R.id.username,R.id.usermajor};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,stumaps,R.layout.spin2layout,key,value);
        spin2.setAdapter(simpleAdapter);
    }
}
