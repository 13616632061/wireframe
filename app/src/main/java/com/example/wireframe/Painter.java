package com.example.wireframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Painter extends View {
    private ArrayList<Integer> data1;
    Paint p1,p2,paint_dottedline;
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
        p1.setTextSize(40);
        p2=new Paint();
        p2.setColor(0xff00ffff);


        setLayoutParams(new ViewGroup.LayoutParams(
                (int) (this.data1.size() * 40),
                ViewGroup.LayoutParams.MATCH_PARENT));

    }
    Path path=new Path();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x1=0;
        int x2=0;
        int y1=0;
        int y2=0;
        int d=60;
        Shader mShader = new LinearGradient(0, 0, 0, getHeight(), new int[] {
                Color.argb(100, 0, 255, 255), Color.argb(45, 0, 255, 255),
                Color.argb(10, 0, 255, 255) }, null, Shader.TileMode.CLAMP);
        p2.setShader(mShader);

        for(int i=0;i<data1.size()-1;i++){
            x1=d*i;
            x2=d*(i+1);
            y1=getHeight()-data1.get(i);
            y2=getHeight()-data1.get(i+1);

            canvas.drawLine(x1,y1,x2,y2,p1);
//
//            path.moveTo(0,y1);
            path.lineTo(x1,y1);

            if(i==data1.size()-2){
                path.lineTo(x2, y2);
                path.lineTo(x2, getHeight());
                path.lineTo(0, getHeight());
                path.close();
                canvas.drawPath(path,p2);
            }
        canvas.drawText(data1.get(i)+"",x1,y1,p1);

        }


//        Path path1=new Path();
//        path1.lineTo(x2, y2);
//        path1.lineTo(x2, getHeight());
//        path1.lineTo(0, getHeight());
//        PathEffect pathEffect=new DashPathEffect(new float[] { d * 0.3f,
//                d * 0.3f, d * 0.3f, d * 0.3f }, d * 0.1f);
//        p2.setPathEffect(pathEffect);
//        canvas.drawPath(path1,p2);

    }
}
