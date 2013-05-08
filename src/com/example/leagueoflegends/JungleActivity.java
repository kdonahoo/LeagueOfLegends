package com.example.leagueoflegends;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class JungleActivity extends Activity implements OnClickListener {
	
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
		setContentView(R.layout.activity_jungle);
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
	
	int blueGolemCounter = 1;
	int purpleGolemCounter = 1;
	int blueLizardCounter = 1;
	int purpleLizardCounter = 1;
	int dragonCounter = 1;
	int baronCounter = 1;
	
    public void onClick(View v) {
    	Timer timer = new Timer();
        if(v == mBlueGolem) {
        	if(blueGolemCounter == 1) {
        		timer.startTimer(20, mBlueGolemText);
        		blueGolemCounter = 0;
        	}
        	
        }
        else if(v == mPurpleGolem) {
        	if(purpleGolemCounter == 1) {
        		timer.startTimer(20, mPurpleGolemText);
        		purpleGolemCounter = 0;
        	}
        	
        }
        else if(v == mBlueLizard) {
        	if(blueLizardCounter == 1) {
        		timer.startTimer(20, mBlueLizardText);
        		blueLizardCounter = 0;
        	}
        }
        else if(v == mPurpleLizard) {
        	if(purpleLizardCounter == 1) {
        		timer.startTimer(20, mPurpleLizardText);
        		purpleLizardCounter = 0;
        	}
        }
        else if(v == mDragon) {
        	if(dragonCounter == 1) {
        		timer.startTimer(20, mDragonText);
        		dragonCounter = 0;
        	}
        }
        else if(v == mBaron) {
        	if(baronCounter == 1) {
        		timer.startTimer(20, mBaronText);
        		baronCounter = 0;
        	}
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
			if(seconds < 10) {
				t = minutes + ":0" + seconds;
			} else {
				t = minutes + ":" + seconds;
			}
			if(bool == 0) {
				v.setText(t);
				seconds--;
				if(seconds < 0) {
					minutes--;
					seconds = 59;
				}
				if(minutes < 0)
				{
					bool = 1;
					if(v == mBlueGolemText) {
			        	blueGolemCounter = 1;
			        	
			        }
			        else if(v == mPurpleGolemText) {
			        	purpleGolemCounter = 1;
			        	
			        }
			        else if(v == mBlueLizardText) {
			        	blueLizardCounter = 1;
			        	
			        }
			        else if(v == mPurpleLizardText) {
			        	purpleLizardCounter = 1;
			        	
			        }
			        else if(v == mDragonText) {
			        	dragonCounter = 1;
			        	
			        }
			        else if(v == mBaronText) {
			        	baronCounter = 1;
			        	
			        }
				} else {
					handler.postDelayed(this, 1000);
				}
			} 
		}
		
	}
	

}