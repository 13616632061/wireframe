package com.example.wireframe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PainterActivity extends Activity {

    @BindView(R.id.layout1)
    RelativeLayout layout1;

    private ArrayList<Integer> data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);
        ButterKnife.bind(this);

        data1=new ArrayList<Integer>();
        for(int i=0;i<30;i++){
          data1.add((int) (Math.random()*100));
        }
        layout1.addView(new Painter(PainterActivity.this,data1));
    }
}
