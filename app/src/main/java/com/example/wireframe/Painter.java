package com.example.wireframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Painter extends View {
    private ArrayList<Integer> data1;
    Paint p1;
    public Painter(Context context, ArrayList<Integer> data1) {
        super(context);
        init(data1);
    }

    private void init(ArrayList<Integer> data1) {
        this.data1=data1;

         p1=new Paint();
        p1.setColor(0xff00ffff);
        p1.setAntiAlias(true);
        p1.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x1=0;
        int x2=0;
        int y1=0;
        int y2=0;
        int d=10;

        Path path=new Path();
        for(int i=0;i<data1.size()-1;i++){
            x1=i;
            x2=d+i+1;
            y1=data1.get(i);
            y2=data1.get(i+1);
            path.moveTo(0,getHeight());
            path.lineTo(x1,y1);
            canvas.drawLine(x1,y1,x2,y2,p1);
        }


    }
}
