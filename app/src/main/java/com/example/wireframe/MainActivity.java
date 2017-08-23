package com.example.wireframe;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.app.Activity;

public class MainActivity extends Activity implements View.OnClickListener {

	LinearLayout arc;
    RelativeLayout pillars,linear;

	private Button btn_panit;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_panit= (Button) findViewById(R.id.btn_panit);
		btn_panit.setOnClickListener(this);

		arc = (LinearLayout) findViewById(R.id.arc);//圆弧计分
		arc.addView(new HomeArc(this, 90)); 
		
		List<Score> list = new ArrayList<Score>();;//柱状图  范围10-100
		for (int i = 0; i < 28; i++) {
			Score s = new Score();
			s.date = "2013-10-" + i;
			s.score = getRandom(10,100);
			list.add(s);
		}
		pillars= (RelativeLayout) findViewById(R.id.pillars);
		pillars.addView(new HomeColumnar(this,list));
		
		List<Integer> lists = new ArrayList<Integer>();//线性图  范围10-100
		for (int i = 0; i < 48; i++) {
			if (i < 8 || i == 28 || i == 12 || i == 18 || i == 20 || i == 30
					|| i == 34) {
				lists.add(0);
			} else {
				lists.add(getRandom(0, 500));
			}
		}
		linear= (RelativeLayout) findViewById(R.id.linear);
		linear.addView(new HomeDiagram(this,lists));
	}
	
	public int getRandom(int min,int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}

	@Override
	public void onClick(View v) {

	}
}
