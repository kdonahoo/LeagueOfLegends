package com.example.leagueoflegends;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	final int MSG_START_TIMER = 0;
    final int MSG_STOP_TIMER = 1;
    final int MSG_UPDATE_TIMER = 2;
    final int REFRESH_RATE = 100;

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
            case MSG_START_TIMER:
                timer.start(); //start timer
                mHandler.sendEmptyMessage(MSG_UPDATE_TIMER);
                break;

            case MSG_UPDATE_TIMER:
                tvTextView.setText(""+ timer.getElapsedTime());
                mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIMER,REFRESH_RATE); //text view is updated every second, 
                break;                                  //though the timer is still running
            case MSG_STOP_TIMER:
                mHandler.removeMessages(MSG_UPDATE_TIMER); // no more updates.
                timer.stop();//stop timer
                tvTextView.setText(""+ timer.getElapsedTime());
                break;

            default:
                break;
            }
        }
    };

    TextView tvTextView;
    Button btnStart,btnStop;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTextView = (TextView)findViewById(R.id.TextView01);

        btnStart = (Button)findViewById(R.id.Button01);
        btnStop= (Button)findViewById(R.id.Button02);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(btnStart == v)
        {
            mHandler.sendEmptyMessage(MSG_START_TIMER);
        }else
        if(btnStop == v){
            mHandler.sendEmptyMessage(MSG_STOP_TIMER);
        }
    }
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
