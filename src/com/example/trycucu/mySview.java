package com.example.trycucu;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.transform.stream.StreamSource;

import org.xmlpull.v1.XmlPullParserException;

import android.R;
import android.R.color;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class mySview extends SurfaceView implements SurfaceHolder.Callback {
	int ysizeofbmp;
	int xsizeofbmp;
	int score;
	int touchY;
	int touchX;
	int bikewid=50;
	int bikehi=50;
	int bikekavoa;
	private MasterThread mt;
	private Activity myactivity;
	private int screenW = 0, screenH = 0;
	Handler hdl;
	Handler hd2;
	Handler hd3;
	int meter;
	Random rnd;
	Random agernd;
	Random checkifpregnent;
	int ispregnent;
	int ispregnent1;
	int ispregnent2;
	int ispregnent3;
	int ispregnent4;
	AssetManager am;
	private int radius;
	private Paint ptext1;
	private int x;
	private int x1 = 0;
	private int x2 = 0;
	private int x3 = 0;
	private int x4 = 0;
	Bitmap bmp;
	Bitmap bmp77;
	Bitmap ofnoa1slow;
	Bitmap ofnoa2slow;
	Bitmap ofnoa1fast;
	Bitmap ofnoa2fast;
	Bitmap ofnoa3slow;
	Bitmap ofnoa3fast;
	
	
	
	Intent intosv;
	MainActivity ma;
	int countforim=0;
	
	Bitmap scabmp;
	Bitmap ofnoa;
	Bitmap bmp1;
	Bitmap scabmp1;
	Bitmap bmp2;
	Bitmap scabmp2;
	Bitmap bmp3;
	Bitmap scabmp3;
	Bitmap bmp4;
	Bitmap scabmp4;
	private int placeoffaling;
	private int speedoffaling;
	private int placeoffaling1 = 100;
	private int speedoffaling1 = -300;
	private int placeoffaling2 = 200;
	private int speedoffaling2 = -300;
	private int placeoffaling3 = 400;
	private int speedoffaling3 = -300;
	private int placeoffaling4 = 600;
	private int speedoffaling4 = -300;
	int lives = 3;
	int chancetogetpragnent = 3;
	int count;
	int count1;
	int count2;
	int count3;
	int count4;
	int bikeleft;
	int regularscore=10;
	int speedscore=1;
	int levelscore=1;
	int ll=0;
	MediaPlayer coin;
	int placeofcoinx=0;
	int placeofcoiny=0;
	
	int wicplayer;
	
	Bitmap bmpwavs;
	Bitmap bmpwavs2;
	Bitmap bmpscalewaves;
	Bitmap bmpscalewaves2;
	
	
	int ordinaryhi=100;
	int ordinarywid=100;
	Paint p1;
	Paint p2;
	Paint p3;
	Paint p4;
	Paint p5;
	int wid = 100;
	int wid1 = 100;
	int wid2 = 100;
	int wid3 = 100;
	int wid4 = 100;
	int hi = 100;
	int hi1 = 100;
	int hi2 = 100;
	int hi3 = 100;
	int hi4 = 100;
	int stoppragnent;
	int stoppragnent1;
	int stoppragnent2;
	int stoppragnent3;
	int stoppragnent4;
	int sizeofbirth;
	Intent intttt;
	Bitmap rndbmp1;
	Bitmap rndbmp2;
	Bitmap rndbmp3;
	Bitmap rndbmp4;
	Bitmap rndbmp5;
	Bitmap rndbmp6;
	Bitmap bmpmoney;
	Bitmap bmpmoney2;
	int cucucount;
	
	int age;
	int age1;
	int age2;
	int age3;
	int age4;
	int realage;
	int realage1;
	int realage2;
	int realage3;
	int realage4;
	int highofwaves;
	int highofwaves2;
	int speednow=3;
	int speednow2=3;
	int iscliked=1;

	int statusofgame = 0;

	public int getWicplayer() {
		return wicplayer;
	}

	public void setWicplayer(int wicplayer) {
		this.wicplayer = wicplayer;
	}
	public int getTouchY() {
		return touchY;
	}

	public void setTouchY(int touchY) {
		this.touchY = touchY;
	}

	public int getTouchX() {
		return touchX;
	}

	public void setTouchX(int touchX) {
		this.touchX = touchX;
	}
	

	public int getYsizeofbmp() {
		return ysizeofbmp;
	}

	public void setYsizeofbmp(int ysizeofbmp) {
		this.ysizeofbmp = ysizeofbmp;
	}

	public int getXsizeofbmp() {
		return xsizeofbmp;
	}

	public void setXsizeofbmp(int xsizeofbmp) {
		this.xsizeofbmp = xsizeofbmp;
	}
	public int getMeter() {
		return meter;
	}
	
	

	public int getSpeedscore() {
		return speedscore;
	}

	public void setSpeedscore(int speedscore) {
		this.speedscore = speedscore;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public int getIscliked() {
		return iscliked;
	}

	public void setIscliked(int iscliked) {
		this.iscliked = iscliked;
	}

	public mySview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
		myactivity = (Activity) context;

		AssetManager a = myactivity.getAssets();
		
//		wichplayer();
		
		rnd = new Random();
		agernd = new Random();
		checkifpregnent = new Random();
		age = 1 + agernd.nextInt(30);
		realage = age / 7;
		ptext1 = new Paint();
		ptext1.setColor(Color.BLACK);
		
		p1 = new Paint();
		p2 = new Paint();
		p3 = new Paint();
		p4 = new Paint();
		p5 = new Paint();
		

		x = 2 + rnd.nextInt(6);
		

		hdl = new Handler();
		hd2 = new Handler();
		hd3 = new Handler();
		rnd = new Random();
		
		
		AssetManager assets = myactivity.getAssets();
		InputStream stream;

		try {
			stream = assets.open("shark1.jpg");
			bmp = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark2.jpg");
			bmp1 = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark3.jpg");
			bmp2 = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark4.jpg");
			bmp3 = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark1.jpg");
			bmp4 = BitmapFactory.decodeStream(stream);
			stream = assets.open("wave_3.png");
			bmpmoney = BitmapFactory.decodeStream(stream);
			stream = assets.open("waves-01.png");
			bmpwavs= BitmapFactory.decodeStream(stream);
			stream = assets.open("waves-01.png");
			bmpwavs2= BitmapFactory.decodeStream(stream);
			bmp77 = BitmapFactory.decodeStream(stream);
			stream = assets.open("dsmall.png");
			
			ysizeofbmp += bmp.getWidth();
			xsizeofbmp += bmp.getHeight();
			highofwaves=screenH/2;
			highofwaves2=highofwaves-bmpwavs2.getHeight();
			
			int kkk=rnd.nextInt(4)+1;
			int kkk1=rnd.nextInt(4)+1;
			int kkk2=rnd.nextInt(4)+1;
			int kkk3=rnd.nextInt(4)+1;
			
			if(wid<0)wid=0;
			if(hi<0)hi=0;
			if(wid1<0)wid1=0;
			if(hi1<0)hi1=0;
			if(wid2<0)wid2=0;
			if(hi2<0)hi2=0;
			if(wid2<0)wid3=0;
			if(hi3<0)hi3=0;
			if(bikewid<0)bikewid=0;
			if(bikehi<0)bikehi=0;

			
			
			
			if     (kkk%4==0)rndbmp1=bmp;
			 else if(kkk%3==0)rndbmp1=bmp2;
			 else if(kkk%2==0)rndbmp1=bmp3;
			 else rndbmp1=bmp4;
			
			if     (kkk1%4==0)rndbmp2=bmp;
			 else if(kkk1%3==0)rndbmp2=bmp2;
			 else if(kkk1%2==0)rndbmp2=bmp3;
			 else rndbmp2=bmp4;
			
			if     (kkk2%4==0)rndbmp3=bmp;
			 else if(kkk2%3==0)rndbmp3=bmp2;
			 else if(kkk2%2==0)rndbmp3=bmp3;
			 else rndbmp3=bmp4;
			
			if     (kkk3%4==0)rndbmp4=bmp;
			 else if(kkk3%3==0)rndbmp4=bmp2;
			 else if(kkk3%2==0)rndbmp4=bmp3;
			 else rndbmp4=bmp4;
			
			
			
			wichplayer();
			 
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		screenW = w;
		screenH = h;
		
		meter = screenW / 20;
		
		sizeofbirth = screenW / 2;
bikehi=100*meter/27;
bikewid=75*meter/27;



ptext1.setTextSize(screenH/25);
		
placeofcoinx=rnd.nextInt(screenW-(meter*3/2));
		placeoffaling = rnd.nextInt(screenW);
		placeoffaling1 = rnd.nextInt(screenW);
		placeoffaling2 = rnd.nextInt(screenW);
		placeoffaling3 = rnd.nextInt(screenW);
		placeoffaling4 = rnd.nextInt(screenW);
		bikekavoa=screenH-(50*meter/27)-bikehi;
		bikeleft=(screenW/2)-(bikewid/2);
	
		
	
	}

	

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mt = new MasterThread(holder);
		mt.setRunning(true);
		mt.start();

	}

	
	


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		boolean retry = true;
		mt.setRunning(false);

		while (retry) {
			try {
				mt.join();
				retry = false;

			} catch (InterruptedException e) {

			}
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	public void onPause() {
		if (mt != null)
			mt.setRunning(false);

	}

	public void resume() {
		if (mt != null)
			mt.setRunning(true);

	}

	// my class
	private class MasterThread extends Thread {
		private SurfaceHolder sh;
		private boolean mRunning;

		public MasterThread(SurfaceHolder sh) {
			super();
			this.sh = sh;
			setName("MasterThread");
		}

		public void setRunning(boolean r) {
			mRunning = r;
		}

		@Override
		public void run() {
			Canvas can = null;
			long previousFrameTime = System.currentTimeMillis();

			while (mRunning) {
				try {
					can = sh.lockCanvas(null);
					synchronized (sh) {
						long currentTime = System.currentTimeMillis();
						double elapsedTimeMS = currentTime - previousFrameTime;
						updatePositions(elapsedTimeMS);
						drawGameElements(can);
						previousFrameTime = currentTime;
					}
				} finally {
					if (can != null)
						sh.unlockCanvasAndPost(can);
				}
			}
		}
	}

	public void makeMyDialogue(final Context context, String currentScore) {

		final AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
		intttt = new Intent(myactivity, OpeningScreen.class);
		builder2.setTitle("Another game?"); // title bar string

		// message to display game results

		builder2.setMessage("Screw - Score: " + currentScore);

		builder2.setIcon(com.example.trycucu.R.drawable.screwd1);

		builder2.setCancelable(false);

		builder2.setPositiveButton("OK",

		new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// builder2.setMessage("See if you can screw more!");
				intttt.putExtra("xxx", score+"");
//				Toast.makeText(context,score, 1000).show();
				Handler handler23 = new Handler();
				handler23.postDelayed(new Runnable() {
					@Override
					public void run() {
						// >>>>>>>>>RESTART THE GAME HERE <<<<<<<<<<<<<<<<<<

						Intent intent = myactivity.getIntent();
						onPause();
						myactivity.finish();
						myactivity.startActivity(intttt);
						
//						myactivity.startActivity(intent);

					}
				}, 500);
			} // onClick
		} // end anonymous inner class
		); // end call to setPositiveButton


		// create AlertDialog
		onPause();
		AlertDialog resetDialog = builder2.create();
		resetDialog.show(); // display the Dialog

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void updatePositions(double elapsedTimeMS) {
		if(countforim!=10)
		countforim++;
		
		if(countforim<8){
			wichplayer();
		}
		
		//when i got the waves draws
		highofwaves+=5*iscliked;
		highofwaves2+=5*iscliked;
		
		if(highofwaves2>=screenH){
			highofwaves2=highofwaves-bmpwavs2.getHeight();
//			highofwaves2-=screenH;
		}	
		if(highofwaves>=screenH){
			highofwaves=highofwaves2-bmpwavs.getHeight();
//			highofwaves-=screenH;
			
		}
		
		
		
		if(ll>100)ll=0;
		
		ll++;
		
	changeim();

		if((bikeleft>screenW)||(bikeleft+bikewid<0)){
			
			 this.myactivity.runOnUiThread(new Runnable() {
					
				 @Override
				 public void run() {
				 // TODO Auto-generated method stub
				
				 makeMyDialogue(myactivity, score+"");
				
				 }
				 });
			
		}
		
		
		
		
		
		
		
	movecoin();
		

		
		
		
		
		
		
		
		
		
		if(statusofgame==15){
			
			levelscore=2;
			speednow2=4;
		}
		if(statusofgame==25){
			levelscore=3;
			speednow2=5;
		}
		if(statusofgame==35){
			speednow2=6;
			levelscore=4;
		}
		if(statusofgame==50){
			levelscore=5;
			speednow2=7;
		}
		speednow=speednow2*iscliked;
		
		

		bikeleft=bikeleft+touchX*-2;
		
		
	

	move1cucu();
	move2cucu();
	move3cucu();
	move4cucu();
	endgame();
		

		
		
		
		
		

		
		
		
		
	}

	public void drawGameElements(Canvas canvas) {
		

		canvas.drawColor(Color.BLUE);
		//when i got the waves drows
//		bmpscalewaves = Bitmap.createScaledBitmap(bmpwavs, screenW, screenH, false);
//		bmpscalewaves2 = Bitmap.createScaledBitmap(bmpwavs2, screenW, screenH, false);
//		canvas.drawBitmap(bmpscalewaves, 0, highofwaves, p1);
//		canvas.drawBitmap(bmpscalewaves2, 0, highofwaves2, p1);
		canvas.drawBitmap(bmpwavs2, 0, highofwaves2, p1);
		canvas.drawBitmap(bmpwavs, 0, highofwaves, p1);
		
		
		
		scabmp = Bitmap.createScaledBitmap(rndbmp1, wid, hi, false);
		canvas.drawBitmap(scabmp, placeoffaling, speedoffaling, p1);
		scabmp1 = Bitmap.createScaledBitmap(rndbmp2, wid1, hi1, false);
		canvas.drawBitmap(scabmp1, placeoffaling1, speedoffaling1, p2);
		scabmp2 = Bitmap.createScaledBitmap(rndbmp3, wid2, hi2, false);
		canvas.drawBitmap(scabmp2, placeoffaling2, speedoffaling2, p3);
		scabmp3 = Bitmap.createScaledBitmap(rndbmp4, wid3, hi3, false);
		canvas.drawBitmap(scabmp3, placeoffaling3, speedoffaling3, p4);
		ofnoa=Bitmap.createScaledBitmap(bmp77, bikewid, bikehi, false);
		canvas.drawBitmap(ofnoa, bikeleft, bikekavoa, p4);
		bmpmoney2=Bitmap.createScaledBitmap(bmpmoney, meter*3/2, meter*3/2, false);
		canvas.drawBitmap(bmpmoney2, placeofcoinx, placeofcoiny, p4);
		
		

//
		canvas.drawText("score: " + score,screenW/2, screenH/15, ptext1);
		canvas.drawText("lives: " + lives, 10,screenH/15, ptext1);
	}
	
	
	
	
	
	
	
	public void move1cucu(){
	
		
		
		x = speednow + rnd.nextInt(6);
		
			speedoffaling += x * meter/27*1.2;
			
			
			
			
			
			
			
			hi=(50*meter/27)+speedoffaling/20;
			wid=hi;
			
			
			

		 if(((bikeleft>placeoffaling-bikewid)&&(bikeleft<placeoffaling+wid))&&
		 (((speedoffaling+hi+10*meter/27)>bikekavoa)&&((speedoffaling-10*meter/27))<bikekavoa+bikehi)){
		
		
		 lives--;
		
		 speedoffaling=screenH+100;
		 
		
		 }
		
		 //if u missed the cucugirl and she run away
		 if(speedoffaling>screenH){
//			 rnd=new Random();
			 if     ((1+rnd.nextInt(4))%4==0)rndbmp1=bmp;
			 else if((1+rnd.nextInt(4))%3==0)rndbmp1=bmp2;
			 else if((1+rnd.nextInt(4))%2==0)rndbmp1=bmp3;
			 else rndbmp1=bmp4;

			 
			 
			 hi=50*meter/27;
			 wid=50*meter/27;
			 
			 score+=regularscore*speedscore*levelscore;
		 statusofgame++;//change it to when i touch cucumber after
		
		
		 if (statusofgame < 5) {
			 
			 
				placeoffaling =
			
						(rnd.nextInt(screenW))-(scabmp.getWidth());

				if(placeoffaling<0)placeoffaling=0;
				
			}
		 else if (statusofgame < 10) {
				placeoffaling = (rnd.nextInt(screenW / 2) - (scabmp.getWidth()));
				if(placeoffaling<0)placeoffaling=0;

			} else if (statusofgame < 15) {
				placeoffaling =( rnd.nextInt(screenW / 3)
								- (scabmp.getWidth() ));
				if(placeoffaling<0)placeoffaling=0;

			} else {

				placeoffaling = rnd.nextInt((screenW / 4)
								- (scabmp.getWidth() ));
				if(placeoffaling<0)placeoffaling=0;

			}
		 x=speednow+rnd.nextInt(5);
		 speedoffaling=0;
		 speedoffaling+=x*meter/27*1.2;
		
		 }

		
	}

	
	
	
	
	public void move2cucu(){
	
		// move second cucu
		 
		 

		 
		 
		 
		 
		 
		 
		 

		if (statusofgame < 5) {
			x1 = 0;
		}

		else {
			x1 = speednow + rnd.nextInt(5);
	
			speedoffaling1 += x1 * meter/27 *1.2;
		
			
			
			hi1=(50*meter/27)+speedoffaling1/20;
			wid1=hi1;
			

			
			// see if i touched the bitmap:
			 if(((bikeleft>placeoffaling1-10*meter/27-bikewid)&&(bikeleft<placeoffaling1+wid1+10*meter/27))&&
					 (((speedoffaling1+hi1+10*meter/27)>bikekavoa)&&((speedoffaling1-10*meter/27))<bikekavoa+bikehi)){
				 lives--;
					
				 speedoffaling1=screenH+100;
					
					 
		
			}

			// if u missed the cucugirl and she run away
			if (speedoffaling1 > screenH) {
				
				
				 if     ((1+rnd.nextInt(4))%4==0)rndbmp2=bmp;
				 else if((1+rnd.nextInt(4))%3==0)rndbmp2=bmp2;
				 else if((1+rnd.nextInt(4))%2==0)rndbmp2=bmp3;
				 else rndbmp2=bmp4;
				
				
				hi1=50*meter/27;
				wid1=50*meter/27;
				
				
				score+=regularscore*speedscore*levelscore;
				if (statusofgame < 10) {
					placeoffaling1 = screenW
							/ 2
							+ rnd.nextInt((screenW / 2) - (scabmp.getWidth() ));
					if(placeoffaling1< screenW/2)placeoffaling1= screenW/2;
					
					

				} else if (statusofgame < 15) {
					placeoffaling1 = screenW
							/ 3
							+ rnd.nextInt((screenW / 3) - (scabmp.getWidth() ));
					if(placeoffaling1< screenW/2)placeoffaling1= screenW/3;

				} else {

					placeoffaling1 = screenW
							/ 4
							+ rnd.nextInt((screenW / 4) - (scabmp.getWidth() ));
					if(placeoffaling1< screenW/2)placeoffaling1= screenW/4;

				}
				
				
				x1 = speednow + rnd.nextInt(5);
				speedoffaling1 = -50;
				speedoffaling1 += x1 * meter/27 *1.2;
			}

		}

		
	}
	

	public void move3cucu(){
		// move third cucu
		if (statusofgame <= 10) {
			x2 = 0;
		} else {
			
			x2 =speednow + rnd.nextInt(5);
			
			speedoffaling2 += x2 * meter/27 *1.2;
			
			hi2=50*meter/27+speedoffaling2/20;
			wid2=hi2;
			
	
			
//			 see if i touched the bitmap:
			 if(((bikeleft>placeoffaling2-10*meter/27-bikewid)&&(bikeleft<placeoffaling2+wid2+10*meter/27))&&
					 (((speedoffaling2+hi2+10*meter/27)>bikekavoa)&&((speedoffaling2-10*meter/27))<bikekavoa+bikehi)){
					
					
				 lives--;
					
				 speedoffaling2=screenH+100;

			
				
				
			}
			// if u missed the cucugirl and she run away
			if (speedoffaling2 > screenH) {
				
				 if     ((1+rnd.nextInt(4))%4==0)rndbmp3=bmp;
				 else if((1+rnd.nextInt(4))%3==0)rndbmp3=bmp2;
				 else if((1+rnd.nextInt(4))%2==0)rndbmp3=bmp3;
				 else rndbmp3=bmp4;
				
				
				hi2=50*meter/27;
				wid2=50*meter/27;
				
				score+=regularscore*speedscore*levelscore;
				if (statusofgame < 15) {
					placeoffaling2 = 2
							* screenW
							/ 3
							+ rnd.nextInt((screenW / 3) - (scabmp.getWidth() ));

					if(placeoffaling2<2*screenW/3)placeoffaling2=2*screenW/3;
					
					
				} else {

					placeoffaling2 = 2
							* screenW
							/ 4
							+ rnd.nextInt((screenW / 4 )- (scabmp.getWidth() ));
					if(placeoffaling2<2*screenW/4)placeoffaling2=2*screenW/4;

				}
				x2 = speednow + rnd.nextInt(5);
				speedoffaling2 = 0;
				speedoffaling2 += x2 * meter/27 *1.2;
			}
		}
}

	
	
	
	
	public void move4cucu(){

		// move 4 cucu
		if (statusofgame <= 15) {
			x3 = 0;
		} else {
			
			
			x3 = speednow + rnd.nextInt(5);
			
			speedoffaling3 += x3 * meter/27 *1.2;
			hi3=50*meter/27+speedoffaling3/20;
			wid3=hi3;

			
			
			
			// see if i touched the bitmap:
			 if(((bikeleft>placeoffaling3-10*meter/27-bikewid)&&(bikeleft<placeoffaling3+wid3+10*meter/27))&&
					 (((speedoffaling3+hi3+10*meter/27)>bikekavoa)&&((speedoffaling-10*meter/27))<bikekavoa+bikehi)){
					
				 lives--;
					
				 speedoffaling3=screenH+100;
				 
					 
			}
			// if u missed the cucugirl and she run away
			if (speedoffaling3 > screenH) {
				
				
				 if     ((1+rnd.nextInt(4))%4==0)rndbmp4=bmp;
				 else if((1+rnd.nextInt(4))%3==0)rndbmp4=bmp2;
				 else if((1+rnd.nextInt(4))%2==0)rndbmp4=bmp3;
				 else rndbmp4=bmp4;
				
				
				hi3=50*meter/27;
				wid3=50*meter/27;
				
				score+=regularscore*speedscore*levelscore;
				placeoffaling3 = 3 * screenW / 4
						+ rnd.nextInt((screenW / 4) - (scabmp.getWidth() ));
				if(placeoffaling3<3 * screenW / 4)placeoffaling3=3 * screenW / 4;
				
				
				
				x3 = speednow + rnd.nextInt(5);
				speedoffaling3 = 0;
				speedoffaling3 += x3 * meter/27 *1.2;
			}
		}
}
	
	
	
	public void endgame() {
		
		if(lives<=0){
			 this.myactivity.runOnUiThread(new Runnable() {
					
					 @Override
					 public void run() {
					 // TODO Auto-generated method stub
					
					 makeMyDialogue(myactivity, score+"");
					
					 }
					 });
		}
	}
	
	
	public void movecoin() {
		
		//move the coin!!
		
		if(	placeofcoiny<=screenH+meter*3/2)
		{
			
			placeofcoiny+=10*iscliked;
			
		}
			
			
		
		else{ 
//			if(	placeofcoiny>screenH+meter*3/2){
		placeofcoinx=rnd.nextInt(screenW-(meter*3/2));
		
		
		
		placeofcoiny=-meter;
		placeofcoiny+=10*iscliked;
		
		
		
	}
		
		
		//see if i touched the coin:
		 if(((bikeleft>placeofcoinx-bikewid)&&(bikeleft<placeofcoinx+(meter*3/2)))&&
		 (((placeofcoiny+(meter*3/2)+10*meter/27)>bikekavoa)&&((placeofcoiny-10*meter/27))<bikekavoa+bikehi)){
			 placeofcoinx=rnd.nextInt(screenW-(meter*3/2));
			 placeofcoiny=-meter;
			 score+=100;
			 
			 
			 
			 
			 
			 
		 }
	
	}
	
	
	
	
	public void wichplayer() {
		
	//0=gil 1=tim 2=guy
		
//		ma=new MainActivity();
//	wicplayer=	ma.getWichp();
//	
	
	
	if(wicplayer==0){
		
		AssetManager assets = myactivity.getAssets();
		InputStream stream;

		try {
			stream = assets.open("Jet_Ski_small_1-01.png");
			ofnoa1slow = BitmapFactory.decodeStream(stream);
			stream = assets.open("Jet_Ski_small_2-01.png");
			ofnoa2slow = BitmapFactory.decodeStream(stream);
			stream = assets.open("Jet_Ski_small_1-01.png");
			ofnoa1fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark3.jpg");
			ofnoa2fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("Jet_Ski_small_3-01.png");
			ofnoa3fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("Jet_Ski_small_3-01.png");
			ofnoa3slow = BitmapFactory.decodeStream(stream);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	else if(wicplayer==1){
		AssetManager assets = myactivity.getAssets();
		InputStream stream;
		try {
			
			stream = assets.open("shark3.jpg");
			ofnoa1fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark2.jpg");
			ofnoa1slow = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark3.jpg");
			ofnoa2fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark2.jpg");
			ofnoa2slow = BitmapFactory.decodeStream(stream);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}	
	
	else if(wicplayer==2){
		AssetManager assets = myactivity.getAssets();
		InputStream stream;
		try {
			stream = assets.open("shark1.jpg");
			ofnoa1fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark2.jpg");
			ofnoa1slow = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark1.jpg");
			ofnoa2fast = BitmapFactory.decodeStream(stream);
			stream = assets.open("shark2.jpg");
			ofnoa2slow = BitmapFactory.decodeStream(stream);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public void changeim() {

		
		
		if(iscliked==1){
		cucucount++;
		if(cucucount%20==0){ bmp77=ofnoa2slow;
		
		}
		else if(cucucount%10==0){
			bmp77=ofnoa1slow;
			
		}
//		else if(cucucount%16==0){ bmp77=ofnoa3slow;
//		
//		}
	else if(cucucount%5==0){ bmp77=ofnoa3slow;
	
	}
		
		}
		
		else{
			cucucount++;
		
			if(cucucount%20==0){
				bmp77=ofnoa1fast;
				
			}
			else if(cucucount%15==0){ bmp77=ofnoa3fast;
			
			}
			else if(cucucount%10==0){ bmp77=ofnoa2fast;
			
			}
		else if(cucucount%5==0){ bmp77=ofnoa3fast;
		
		}
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	

}
