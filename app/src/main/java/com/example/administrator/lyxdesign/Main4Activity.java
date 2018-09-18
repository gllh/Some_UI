package com.example.administrator.lyxdesign;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ViewSwitcher;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener,ViewSwitcher.ViewFactory{
    private ImageSwitcher is1;
    private Button bt_uppic;
    private Button bt_downpic;
    private Drawable dra;
    private int imageindex=0;

    private ProgressBar pb;

    private String imurl[]={"http://cdn.wonderfulengineering.com/wp-content/uploads/2015/05/San-Francisco-Wallpaper-11.jpg" ,
            "https://cdn.thecrazytourist.com/wp-content/uploads/2015/09/Homes-on-Beach-Ave-in-Cape-May-New-Jersey.jpg" ,
            "https://wallpaperlayer.com/img/2015/8/wonderful-california-wallpaper-7151-7433-hd-wallpapers.jpg" ,
            "http://www.projects.aegee.org/suct/su2014/images/SUs/IST1_4_istanbul4.jpg" ,
            "http://cdn.wonderfulengineering.com/wp-content/uploads/2016/01/eqypt-wallpaper-3.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
        bt_uppic.setOnClickListener(this);
        bt_downpic.setOnClickListener(this);
    }
    private void init()
    {
        bt_downpic=(Button)findViewById(R.id.bt_downpic);
        bt_uppic=(Button)findViewById(R.id.bt_uppic);
        is1=(ImageSwitcher)findViewById(R.id.imswi);
        pb = (ProgressBar) findViewById(R.id.pb);
        is1.setFactory(this);
        pb.setProgress(0);
        dra= ResourcesCompat.getDrawable(getResources(),R.drawable.load1,null);
        is1.setImageDrawable(dra);
    }
    public void onClick(View view){
        if(view.getId()==R.id.bt_downpic)
        {
            imageindex++;
            if(imageindex>4)
            {
                imageindex=0;
            }
            is1.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.leftin));
            is1.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.rightout));
            new Thread(updateThread).start();
        }else if(view.getId()==R.id.bt_uppic)
        {
            imageindex--;
            if(imageindex<0)
            {
                imageindex=4;
            }
            is1.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.rightin));
            is1.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.leftout));
            new Thread(updateThread).start();
        }
    }
    Runnable updateThread = new Runnable() {
        private int percent;
        @Override
        public void run() {
            Bitmap bm=null;
            try{
                URL url=new URL(imurl[imageindex]);
                URLConnection connection=url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                bm= BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            final Bitmap bitmap=bm;
            BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
            dra=bitmapDrawable;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            is1.post(new Runnable() {
                @Override
                public void run() {
                    is1.setImageDrawable(dra);
                }
            });
        }
    };
    @Override
    public View makeView() {
        ImageView imageView=new ImageView(this);
        return imageView;
    }

}
