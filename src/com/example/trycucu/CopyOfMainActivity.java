package com.example.trycucu;

import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class CopyOfMainActivity extends ActionBarActivity {

	mySview sv;
	ImageView ee;
	
	   JSONArray data;
	   JSONObject bestSCORE;
	   
	   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv=(mySview) findViewById(R.id.flappyview);
      

        
        
        
        
        

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
		sv.resume();
		
		super.onResume();
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
			sv.setTouchY((((int) event.getY())-(20*sv.getMeter())));
			sv.setTouchX(((int) event.getX()+(4*sv.getMeter())));
			
			break;
		case MotionEvent.ACTION_UP:
			sv.setTouchY(-1000);
			sv.setTouchX(-1000);
			
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
    
}
