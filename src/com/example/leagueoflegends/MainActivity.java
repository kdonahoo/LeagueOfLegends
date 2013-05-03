package com.example.leagueoflegends;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private ImageView mBlueGolem;
	private TextView mBlueGolemText;
	private ImageView mPurpleGolem;
	private TextView mPurpleGolemText;
	private ImageView mBlueLizard;
	private TextView mBlueLizardText;
	private ImageView mPurpleLizard;
	private TextView mPurpleLizardText;
	private ImageView mDragon;
	private TextView mDragonText;
	private ImageView mBaron;
	private TextView mBaronText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBlueGolem = (ImageView) findViewById(R.id.blueBlueBuff);
		mPurpleGolem = (ImageView) findViewById(R.id.purpleBlueBuff);
		mBlueLizard = (ImageView) findViewById(R.id.blueRedBuff);
		mPurpleLizard = (ImageView) findViewById(R.id.purpleRedBuff);
		mDragon = (ImageView) findViewById(R.id.dragon);
		mBaron = (ImageView) findViewById(R.id.baron);
		mBlueGolemText = (TextView) findViewById(R.id.blueBlueBuffText);
		mPurpleGolemText = (TextView) findViewById(R.id.purpleBlueBuffText);
		mBlueLizardText = (TextView) findViewById(R.id.blueRedBuffText);
		mPurpleLizardText = (TextView) findViewById(R.id.purpleRedBuffText);
		mDragonText = (TextView) findViewById(R.id.dragonText);
		mBaronText = (TextView) findViewById(R.id.baronText);
		
		mBlueGolem.setOnClickListener(this);
		mPurpleGolem.setOnClickListener(this);
		mBlueLizard.setOnClickListener(this);
		mPurpleLizard.setOnClickListener(this);
		mDragon.setOnClickListener(this);
		mBaron.setOnClickListener(this);
		
	}
	
    public void onClick(View v) {
    	Timer timer = new Timer();
        if(v == mBlueGolem) {
        	timer.startTimer(300, mBlueGolemText);
        }
        else if(v == mPurpleGolem) {
        	timer.startTimer(300, mPurpleGolemText);
        }
        else if(v == mBlueLizard) {
        	timer.startTimer(300, mBlueLizardText);
        }
        else if(v == mPurpleLizard) {
        	timer.startTimer(300, mPurpleLizardText);
        }
        else if(v == mDragon) {
        	timer.startTimer(360, mDragonText);
        }
        else if(v == mBaron) {
        	timer.startTimer(420, mBaronText);
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class Timer implements Runnable {
		public Handler handler = new Handler();
		public TextView v;
		public String t;
		public int minutes;
		public int seconds;
		public int timeTracker;
		public int bool;
		
		public void startTimer(int time, TextView view) {
			minutes = time/60;
			seconds = time - minutes*60;
			v = view;
			bool = 0;
			handler.postDelayed(this, 1000);
		}
		
		@Override
		public void run() {
			if(seconds < 10)
			{
				t = minutes + ":0" + seconds;
			} else {
				t = minutes + ":" + seconds;
			}
			if(bool == 0)
			{
				v.setText(t);
				seconds--;
				if(seconds < 0) {
					minutes--;
					seconds = 59;
				}
				if(minutes < 0)
				{
					bool = 1;
				}
				handler.postDelayed(this, 1000);
			} else {
				
			}
			
		}
	}
	

}
