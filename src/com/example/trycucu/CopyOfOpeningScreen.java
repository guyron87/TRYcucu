package com.example.trycucu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CopyOfOpeningScreen extends Activity {

	TextView tv1;
	
	Button play1;
	
	
	   JSONArray data;
	   JSONObject bestSCORE;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opening_screen);
		
		
		
		
		tv1=(TextView) findViewById(R.id.FILETESTtextView1);
		play1=(Button) findViewById(R.id.PLAYbutton1);
		
		
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		play1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Intent i = new Intent(CopyOfOpeningScreen.this, MainActivity.class);
   				
	       		

   				startActivity(i);

   				i = getIntent();
				
			}
		});
		
		
	}
	
	
	public void readFile() throws IOException, JSONException {

		FileInputStream fis = openFileInput("mission1RES");
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		StringBuffer b = new StringBuffer();
		
		while (bis.available() != 0) {
			char c = (char) bis.read();
			b.append(c);
		}
		bis.close();
		fis.close();
		

		JSONArray data = new JSONArray(b.toString());//<<::::::___)<---1

		StringBuffer toursBuffer = new StringBuffer();
		
		for (int i = 0; i < data.length(); i++) {
			
			String tour1 = data.getJSONObject(i).getString("best");
			
			
			toursBuffer.append(tour1 );
			
			if(!(toursBuffer==null)){
				
				tv1.setText(toursBuffer.toString());

				Toast.makeText(CopyOfOpeningScreen.this, toursBuffer.toString(), 2000).show();
			}
			
	
		}

		
	}
	
	
	   public void createFile( ) throws IOException, JSONException 
			{

				

			    data = new JSONArray();
				
				
			  		bestSCORE = new JSONObject();
			  		
			  		try {
			  			
			  			bestSCORE.put("best", "888");
						data.put(bestSCORE);
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				String text = data.toString();//note1

				
				
				FileOutputStream fos = openFileOutput("mission1RES", MODE_PRIVATE);
				
				Toast.makeText(this, "WRITTEN>>>>", 1000).show();
				fos.write(text.getBytes());//note2
				fos.close();

				
						

			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opening_screen, menu);
		return true;
	}

}
