package com.example.administrator.lyxdesign;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_save;
    private EditText inputsave;
    private Button bt_read;
    private Button bt_sdread;
    private Button bt_sdwrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        init();
        bt_save.setOnClickListener(this);
        bt_read.setOnClickListener(this);
        bt_sdwrite.setOnClickListener(this);
        bt_sdread.setOnClickListener(this);
    }

    private void init() {
        inputsave = (EditText) findViewById(R.id.inputsave);
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_read=(Button)findViewById(R.id.bt_read);
        bt_sdread=(Button)findViewById(R.id.bt_sdread);
        bt_sdwrite=(Button)findViewById(R.id.bt_sdwrite);
    }

    private String read() {
        FileInputStream in = null;
        String info = "";
        try {
            in = new FileInputStream("/data/data/com.example.administrator.lyxdesign/lyx.txt");
            byte[] bytes = new byte[2014];
            int len = in.read(bytes);
            info = new String(bytes, 0, len);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return info;
    }
private void  write(String info){
    FileOutputStream out=null;
    try {
        out = new FileOutputStream("/data/data/com.example.administrator.lyxdesign/lyx.txt");
        out.write(info.getBytes());
        Toast.makeText(this,"输入成功",Toast.LENGTH_SHORT).show();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
    @Override
    public void  onClick(View view){
        Intent intent=new Intent();
        if(view.getId()==R.id.bt_save){
            String info=inputsave.getText().toString();
            write(info);
            inputsave.getText().clear();
        }else if(view.getId()==R.id.bt_read){
            Toast.makeText(this,read(),Toast.LENGTH_LONG).show();
        }else if(view.getId()==R.id.bt_sdwrite){
            String info=inputsave.getText().toString();
            sdwrite(info);
            exitsd();
            inputsave.getText().clear();
        }else if(view.getId()==R.id.bt_sdread){
            Toast.makeText(this,sdread(),Toast.LENGTH_SHORT).show();
            exitsd();
        }
    }
    private void  sdwrite(String info){
        FileOutputStream out=null;
        try {
            File file=Environment.getExternalStorageDirectory();
            String path=file.getPath();
            out = new FileOutputStream(path+"/lyx.txt");
            out.write(info.getBytes());
            Toast.makeText(this,"输入成功",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private String sdread() {
        FileInputStream in = null;
        String info = "";
        try {
            File file=Environment.getExternalStorageDirectory();
            String path=file.getPath();
            in = new FileInputStream(path+"/lyx.txt");
            byte[] bytes = new byte[2014];
            int len = in.read(bytes);
            info = new String(bytes, 0, len);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return info;
    }
    private void exitsd(){
        String state= Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            Toast.makeText(this,"有sd卡",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"no sdcard",Toast.LENGTH_SHORT).show();
        }
    }
}
