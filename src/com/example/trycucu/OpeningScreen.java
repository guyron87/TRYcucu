package com.example.trycucu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OpeningScreen extends Activity {

	TextView tv1;
	TextView tv2;	
	Button play1;
	Context conte=this; 
	Dialog dialog;
	
	   JSONArray data;
	   JSONObject bestSCORE;
	   Intent intosv;
	   String trytotake="0";
	   String trytotake2="0";
	   Intent intttt;
	   SharedPreferences.Editor editor;
	   SharedPreferences sp;
	   int highScore=0;
		int score=0;
		int score2=0;
		MediaPlayer coin;
	   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opening_screen);
		
		
		
		tv2=(TextView) findViewById(R.id.last);
		tv1=(TextView) findViewById(R.id.FILETESTtextView1);
		play1=(Button) findViewById(R.id.PLAYbutton1);
		intosv = new Intent(OpeningScreen.this, MainActivity.class);
		
		
		sp= getSharedPreferences("searches", MODE_PRIVATE);
		
		intttt=getIntent();
		
		trytotake=intttt.getStringExtra("xxx");

		
		
		highScore=sp.getInt("HIGH_SCORE", 0);
		tv2.setText(trytotake);
		 tv1.setText(""+highScore);
		 try {
			    score = Integer.parseInt(tv2.getText().toString());
			} catch(NumberFormatException nfe) {
			   System.out.println("Could not parse " + nfe);
			} 
	

		 
		 
		 dotheshreder();
		
	
		
		play1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				buildcosdi();
				
   				
	       		

				
			}
		});
		
		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opening_screen, menu);
		menu.addSubMenu(1,1 , 1, "erase highscore");
		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	
		if (item.getItemId() == 1) {
			
			
			score=0;
			highScore=0;
			tv1.setText(highScore+"");
			
			SharedPreferences.Editor etor=sp.edit();
etor.clear();
etor.apply();
etor.putInt("HIGH_SCORE", 0);
etor.commit();
			
			
			
			}
		
		return true;

		}
	
	
	
	
	public void buildcosdi() {
		
	

	  dialog = new Dialog(conte);
	dialog.setContentView(R.layout.chosecucualert);
	dialog.setTitle("start the game");

	// set the custom dialog components - text, image and button

	ImageView imageguy = (ImageView) dialog.findViewById(R.id.guy);
	ImageView imagetim = (ImageView) dialog.findViewById(R.id.tim);
	ImageView imagegil = (ImageView) dialog.findViewById(R.id.gil);
	//	imagebeginer.setImageResource(R.drawable.soniasmall);
//	imageregular.setImageResource(R.drawable.soniasmall);
//	imagepro.setImageResource(R.drawable.soniasmall);
//	
//	
	imageguy.setOnClickListener(clickguy);
	//	
	imagetim.setOnClickListener(clicktim);

	//	
	imagegil.setOnClickListener(clickgil);

	
	
	dialog.show();
	
	}
	
	
	
	
	
	OnClickListener clicktim=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
intosv.putExtra("cucu", "tim");
				startActivity(intosv);

//				i = getIntent();
			
			
			
			
		}
	};
	
	
	
	
	
	
	OnClickListener clickguy=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			intosv.putExtra("cucu", "guy");
				startActivity(intosv);

//				i = getIntent();
			
		}
	};
	
	
	
	
	
	
	
OnClickListener clickgil=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		intosv.putExtra("cucu", "gil");
			startActivity(intosv);

//			i = getIntent();
		
	}
};
	



private void dotheshreder() {
	// TODO Auto-generated method stub
	
	
	
	

	if (score > highScore)
	{
		editor = sp.edit();
		editor.putInt("HIGH_SCORE", score);
		editor.commit(); // store the new high score
		highScore = score;
		 tv1.setText(""+highScore);
		
		
		
	} 
	
	
}
	
}
