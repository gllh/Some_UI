package com.example.administrator.lyxdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    private LinearLayout check_sex;
    private  LinearLayout check_project;
    private Button bt_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        check_sex=(LinearLayout)findViewById(R.id.check_sex);
        check_project=(LinearLayout)findViewById(R.id.check_project);
        bt_update=(Button)findViewById(R.id.bt_update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info=getcheckboxinfo(check_sex);
                info+=getcheckboxinfo2(check_project);
                Toast.makeText(Main6Activity.this,info,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  String getcheckboxinfo(LinearLayout check_sex)
    {
        String info="";
        int num=check_sex.getChildCount();
        for(int i=0;i<num;i++)
        {
            CheckBox cb=(CheckBox) check_sex.getChildAt(i);
            if(cb.isChecked())
            {
                info+="性别信息："+"\n"+cb.getText().toString()+"\n";
            }
        }
        return info;
    }
    private  String getcheckboxinfo2(LinearLayout check_project)
    {
        String info="";
        int num=check_project.getChildCount();
        for(int i=0;i<num;i++)
        {
            CheckBox cb=(CheckBox) check_project.getChildAt(i);
            if(cb.isChecked())
            {
                info+="\n"+"选课信息："+"\n"+cb.getText().toString()+"\n";
            }
        }
        return info;
    }
}
