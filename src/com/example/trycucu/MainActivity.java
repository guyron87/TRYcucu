package com.example.trycucu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements SensorEventListener {
	private SensorManager sm = null;
	

	Intent intosv;
	int wichp;
	String which;
	
	mySview sv;
	ImageView ee;
	
	   JSONArray data;
	   JSONObject bestSCORE;
	 
	   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        setContentView(R.layout.activity_main);
        sv=(mySview) findViewById(R.id.flappyview);
        intosv=getIntent();
        which=intosv.getStringExtra("cucu");
        if(which.equals("gil")){
        	wichp=0;
        	
        	
        }
        else if(which.equals("tim")){
        	
        	wichp=1;
        }
        
        else {
        	wichp=2;
        	
        }
        sv.setWicplayer(wichp);
        
        
     
        

    }
    
    
    

    
    
    
	public int getWichp() {
		return wichp;
	}







	public void setWichp(int wichp) {
		this.wichp = wichp;
	}







	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sv.onPause();
		finish();
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sm.SENSOR_DELAY_GAME);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE), sm.SENSOR_DELAY_GAME);
		sv.resume();
    
		
		
	}
	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
    	switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			sv.setIscliked(3);
			sv.setSpeedscore(3);
			
			
			
			break;
		case MotionEvent.ACTION_UP:
			sv.setIscliked(1);
			sv.setSpeedscore(1);
			

			
			try {
				createFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;

//		default:
//			break;
		}
    	
		
		return super.onTouchEvent(event);
    }
//    
    

    
	
    
	
	   public void createFile( ) throws IOException, JSONException 
		{

			

		    data = new JSONArray();
			
			
		  		bestSCORE = new JSONObject();
		  		
		  		try {
		  			
		  			bestSCORE.put("best", sv.score+"");
					data.put(bestSCORE);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			String text = data.toString();//note1

			
			
			FileOutputStream fos = openFileOutput("mission1RES", MODE_PRIVATE);
			
			
			fos.write(text.getBytes());//note2
			fos.close();

			
					

		}

	  
	   
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		 synchronized (this) {
		        switch (event.sensor.getType()){
		            case Sensor.TYPE_ACCELEROMETER:
		            	
		            	
		            	float xxx=event.values[0]*3;
		            	
		            	sv.setTouchX((int) xxx);
		            	

		            break;
		        case Sensor.TYPE_GYROSCOPE:
		        break;
		 
		        }
		    }
		
	
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
    
}
