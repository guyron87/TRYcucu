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
public class CopyOfmySview extends SurfaceView implements SurfaceHolder.Callback {
	int ysizeofbmp;
	int xsizeofbmp;
	int score;
	int touchY;
	int touchX;
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
	Bitmap scabmp;
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
	private int speedoffaling1 = -100;
	private int placeoffaling2 = 200;
	private int speedoffaling2 = -100;
	private int placeoffaling3 = 400;
	private int speedoffaling3 = -100;
	private int placeoffaling4 = 600;
	private int speedoffaling4 = -100;
	int lives = 10;
	int chancetogetpragnent = 3;
	int count;
	int count1;
	int count2;
	int count3;
	int count4;

	
	
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

	int statusofgame = 0;

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

	public CopyOfmySview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);

		myactivity = (Activity) context;

		AssetManager a = myactivity.getAssets();
		rnd = new Random();
		agernd = new Random();
		checkifpregnent = new Random();
		age = 1 + agernd.nextInt(30);
		realage = age / 7;
		ptext1 = new Paint();
		ptext1.setColor(Color.BLUE);
		ptext1.setTextSize(40);
		p1 = new Paint();
		p2 = new Paint();
		p3 = new Paint();
		p4 = new Paint();
		p5 = new Paint();

		x = 1 + rnd.nextInt(6);

		hdl = new Handler();
		hd2 = new Handler();
		hd3 = new Handler();
		rnd = new Random();

		AssetManager assets = myactivity.getAssets();
		InputStream stream;

		try {
			stream = assets.open("dsmall.png");
			bmp = BitmapFactory.decodeStream(stream);
			stream = assets.open("soniasmall.png");
			bmp1 = BitmapFactory.decodeStream(stream);
			stream = assets.open("soniasmall.png");
			bmp2 = BitmapFactory.decodeStream(stream);
			stream = assets.open("soniasmall.png");
			bmp3 = BitmapFactory.decodeStream(stream);
			stream = assets.open("soniasmall.png");
			bmp4 = BitmapFactory.decodeStream(stream);
			ysizeofbmp += bmp.getWidth();
			xsizeofbmp += bmp.getHeight();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		screenW = w;
		screenH = h;
		meter = screenW / 200;
		sizeofbirth = screenW / 2;

		placeoffaling = rnd.nextInt(screenW);
		placeoffaling1 = rnd.nextInt(screenW);
		placeoffaling2 = rnd.nextInt(screenW);
		placeoffaling3 = rnd.nextInt(screenW);
		placeoffaling4 = rnd.nextInt(screenW);

	}

	public int getMeter() {
		return meter;
	}

	public void setMeter(int meter) {
		this.meter = meter;
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

		builder2.setTitle("Another game?"); // title bar string

		// message to display game results

		builder2.setMessage("Screw - Score: " + currentScore);

		builder2.setIcon(com.example.trycucu.R.drawable.screwd1);

		builder2.setCancelable(false);

		builder2.setPositiveButton("OK",

		new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// builder2.setMessage("See if you can screw more!");

				Toast.makeText(context, "Going to Main Menu", 1000).show();
				Handler handler23 = new Handler();
				handler23.postDelayed(new Runnable() {
					@Override
					public void run() {
						// >>>>>>>>>RESTART THE GAME HERE <<<<<<<<<<<<<<<<<<

						Intent intent = myactivity.getIntent();
						onPause();
						myactivity.finish();
						myactivity.startActivity(intent);

					}
				}, 500);
			} // onClick
		} // end anonymous inner class
		); // end call to setPositiveButton

		builder2.setNegativeButton("NOPE",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// Toast.makeText(myactivity.this, "Going to Main Menu",
						// 1200).show();
						Handler handler23 = new Handler();
						handler23.postDelayed(new Runnable() {
							@Override
							public void run() {

								// >>>>>>>>>TAKE HIM TO THE MAIN MENU HERE
								// <<<<<<<<<<<<<<<<<<

								Intent i = new Intent(myactivity,
										OpeningScreen.class);

								myactivity.startActivity(i);

								i = myactivity.getIntent();

							}
						}, 500);

					} // onClick
				} // end anonymous inner class
		);
		// create AlertDialog
		onPause();
		AlertDialog resetDialog = builder2.create();
		resetDialog.show(); // display the Dialog

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void updatePositions(double elapsedTimeMS) {
		// placeoffaling1=100;
		realage = age / 6;
		realage1 = age1 / 6;
		realage2 = age2 / 6;
		realage3 = age3 / 6;
		realage4 = age4 / 6;

		// ///////////////////////////////////////////////////////////////////////////////////////////
		// move first cucu


		
		if (count == 0) {// if she is not pragnent
			speedoffaling += x * meter / 2;
			age++;
		} 
//		else {// if she is pragnent
//			hi += meter / 2;
//			wid += meter / 2;
//
//			if ((hi >= sizeofbirth) || (wid >= sizeofbirth)) {
//				// gameover!!!!!
//
//				// but now justforcheck:
//				this.myactivity.runOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//
//						makeMyDialogue(myactivity, score + "");
//
//					}
//				});
//
//			}
//		}
		 //see if i touched the bitmap:
		
		
		
		 //if(!(scabmp==null)){
		
		 //}
		
		 if(((touchX>placeoffaling-10*meter)&&(touchX<placeoffaling+scabmp.getWidth()+10*meter))&&
		 ((touchY<speedoffaling+scabmp.getHeight()+10*meter)&&(touchY>speedoffaling-10*meter))){
		
		
		 //add or remove points
		 if(realage<18){
		 //end of the game you r geting into jail u pedofile!!!!!
		 //add endofgame method
		 }
		 else if((realage>=18)&&(realage<28)){
		 //goooodddddd u succeeded to do fine lady
		 score+=(100-realage)*2;
		 statusofgame++;
		
		
		
		 //buttt now u should check if u knocked her pregnant
		
//		 ispregnent=checkifpregnent.nextInt(chancetogetpragnent);
//		
//		 //oh-no she is pregnant
//		 if(ispregnent==0){
//		 count++;
//		 speedoffaling1=-screenH/2;
//		 speedoffaling2=-screenH/2;
//		 speedoffaling3=-screenH/2;
//		 speedoffaling4=-screenH/2;
//		
//		
//		 //u can still save yourself just touch her again
//		 hd2.postDelayed(new Runnable() {
//		
//		 @Override
//		 public void run() {
//		 // TODO Auto-generated method stub
//		 if(((touchX>placeoffaling-wid)&&(touchX<placeoffaling+scabmp.getWidth()+wid))&&
//		 ((touchY<speedoffaling+scabmp.getHeight()+hi)&&(touchY>speedoffaling-hi))){
//		 stoppragnent=10;
//		 }
//		 }
//		 }, 10);
//		
//		 if (stoppragnent==10){
//		 stoppragnent=0;
//		 count=0;
//		 speedoffaling=-screenH/50;
//		 speedoffaling+=x*meter/2;
//		 hi=100;
//		 wid=100;
//		 age++;
//		 }
//		
//		
//		
//		
//		 }
		 }
		 else if((realage>=28)&&(realage<45)){
		 //o.k this age for woman its also good
		 score+=(100-realage);
		 statusofgame++;
		
		 }
		 else {
		 // baaaaaaa u make me puke u just lost 1 life
		 lives--;
		 statusofgame++;
		 }
		
		
		 //play the bitmap again:
		 age=10+agernd.nextInt(400);
		 if(count==0){
		 speedoffaling=-screenH/50;
		 
		 if (statusofgame < 5) {
				placeoffaling =
						rnd.nextInt(screenW-(scabmp.getWidth()));

			}
			if (statusofgame < 10) {
				placeoffaling = rnd.nextInt(screenW / 2 - (scabmp.getWidth() / 2));

			} else if (statusofgame < 15) {
				placeoffaling = rnd.nextInt(screenW / 3
								- (scabmp.getWidth() / 2));

			} else {

				placeoffaling = rnd.nextInt(screenW / 4
								- (scabmp.getWidth() / 2));

			}
		 }
		
		 speedoffaling+=x*meter/2;
		
		
		 }
		
		 //if u missed the cucugirl and she run away
		 if(speedoffaling>screenH){
		 age=10+agernd.nextInt(400);
		 statusofgame++;//change it to when i touch cucumber after
		
		
		 if (statusofgame < 5) {
				placeoffaling =
						rnd.nextInt(screenW-(scabmp.getWidth()));

			}
			if (statusofgame < 10) {
				placeoffaling = rnd.nextInt(screenW / 2 - (scabmp.getWidth() / 2));

			} else if (statusofgame < 15) {
				placeoffaling = rnd.nextInt(screenW / 3
								- (scabmp.getWidth() / 2));

			} else {

				placeoffaling = rnd.nextInt(screenW / 4
								- (scabmp.getWidth() / 2));

			}
		 x=1+rnd.nextInt(6);
		 speedoffaling=0;
		 speedoffaling+=x*meter/2;
		
		 }


		 
		 
		// ////////////////////////////////////////////////////////////////////////////////

		// move second cucu

		if (statusofgame <= 5) {
			x1 = 0;
		}

		else {

			if (count == 0) {// if shes not pragnent
				x1 = 1 + rnd.nextInt(6);
				age1++;
				speedoffaling1 += x1 * meter / 2;

			} 
//			else {// if she is pragnent
//				hi1 += meter / 2;
//				wid1 += meter / 2;
//
//				if ((hi1 >= sizeofbirth) || (wid1 >= sizeofbirth)) {
//					// gameover!!!!!
//
//					// but now justforcheck:
//					this.myactivity.runOnUiThread(new Runnable() {
//
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//
//							makeMyDialogue(myactivity, score + "");
//
//						}
//					});
//
//				}
//
//			}

			// see if i touched the bitmap:
			if (((touchX > placeoffaling1 - 10 * meter) && (touchX < placeoffaling1
					+ scabmp1.getWidth() + 10 * meter))
					&& ((touchY < speedoffaling1 + scabmp1.getHeight() + 10
							* meter) && (touchY > speedoffaling1 - 10 * meter))) {

				// add or remove points
				if (realage1 < 18) {
					// end of the game you r geting into jail u pedofil!!!!!
					// add endofgame method
				} else if ((realage1 >= 18) && (realage1 < 28)) {
					// goooodddddd u succeed to do fine lady
					score += (100 - realage1) * 2;

					// buttt now u should check if u got her pragnent

//					ispregnent1 = checkifpregnent.nextInt(chancetogetpragnent);
//
//					// oh-no she is pragnent
//					if (ispregnent1 == 0) {
//						count++;
//						speedoffaling = -screenH / 2;
//						speedoffaling2 = -screenH / 2;
//						speedoffaling3 = -screenH / 2;
//						speedoffaling4 = -screenH / 2;
//
//						// u can still save yourself just touch her again
//						hd2.postDelayed(new Runnable() {
//
//							@Override
//							public void run() {
//								// TODO Auto-generated method stub
//								if (((touchX > placeoffaling1 - wid1) && (touchX < placeoffaling1
//										+ scabmp.getWidth() + wid1))
//										&& ((touchY < speedoffaling1
//												+ scabmp.getHeight() + hi1) && (touchY > speedoffaling1
//												- hi1))) {
//									stoppragnent1 = 10;
//								}
//							}
//						}, 10);
//
//						if (stoppragnent1 == 10) {
//							stoppragnent1 = 0;
//							count = 0;
//							speedoffaling1 = -screenH / 50;
//							speedoffaling1 += x * meter / 2;
//							hi1 = 100;
//							wid1 = 100;
//							age1++;
//						}
//					}
				} else if ((realage1 >= 28) && (realage1 < 45)) {
					// o.k this age for woman its also good
					score += (100 - realage1);

				} else {
					// baaaaaaa u make me puke u just lost 1 life
					lives--;

				}

				// play the bitmap again:
				age1 = 10 + agernd.nextInt(400);
				if ((count == 0)) {
					speedoffaling1 = -screenH / 50;

					if (statusofgame < 10) {
						placeoffaling1 = screenW
								/ 2
								+ rnd.nextInt(screenW / 2
										- (scabmp.getWidth() / 2));

					} else if (statusofgame < 15) {
						placeoffaling1 = screenW
								/ 3
								+ rnd.nextInt(screenW / 3
										- (scabmp.getWidth() / 2));

					} else {

						placeoffaling1 = screenW
								/ 4
								+ rnd.nextInt(screenW / 4
										- (scabmp.getWidth() / 2));

					}

				}
				speedoffaling1 += x1 * meter / 2;
			}

			// if u missed the cucugirl and she run away
			if (speedoffaling1 > screenH) {
				age1 = 10 + agernd.nextInt(400);
				if (statusofgame < 10) {
					placeoffaling1 = screenW
							/ 2
							+ rnd.nextInt(screenW / 2 - (scabmp.getWidth() / 2));

				} else if (statusofgame < 15) {
					placeoffaling1 = screenW
							/ 3
							+ rnd.nextInt(screenW / 3 - (scabmp.getWidth() / 2));

				} else {

					placeoffaling1 = screenW
							/ 4
							+ rnd.nextInt(screenW / 4 - (scabmp.getWidth() / 2));

				}
				x1 = 1 + rnd.nextInt(6);
				speedoffaling1 = 0;
				speedoffaling1 += x1 * meter / 2;
			}

		}

		//
		//
		//
		//

		// /////////////////////////////////////////////////////////////////////////////////
		// move third cucu
		if (statusofgame <= 10) {
			x2 = 0;
		} else {
			if (count == 0) {
				x2 = 1 + rnd.nextInt(6);
				speedoffaling2 += x2 * meter / 2;
				age2++;
			}
//			 else{//if she is pragnent
//			 hi2+=meter/2;
//			 wid2+=meter/2;
//			
//			
//			 if((hi2>=sizeofbirth)||(wid2>=sizeofbirth)){
//			 //gameover!!!!!
//			
//			 //but now justforcheck:
//			 this.myactivity.runOnUiThread(new Runnable() {
//			
//			 @Override
//			 public void run() {
//			 // TODO Auto-generated method stub
//			
//			 makeMyDialogue(myactivity, score+"");
//			
//			 }
//			 });
//			
//			
//			 }
//			
//			
//			 }
//			 see if i touched the bitmap:
			if (((touchX > placeoffaling2 - 10 * meter) && (touchX < placeoffaling2
					+ scabmp2.getWidth() + 10 * meter))
					&& ((touchY < speedoffaling2 + scabmp2.getHeight() + 10
							* meter) && (touchY > speedoffaling2 - 10 * meter))) {

				// add or remove points
				if (realage2 < 18) {
					// end of the game you r geting into jail u pedofil!!!!!
					// add endofgame method
				}  else if ((realage2 >= 18) && (realage2 < 28)) {
					// goooodddddd u succeed to do fine lady
					score += (100 - realage2) * 2;

					// buttt now u should check if u got her pragnent

//					ispregnent2 = checkifpregnent.nextInt(chancetogetpragnent);
//
//					// oh-no she is pragnent
//					if (ispregnent2 == 0) {
//						count++;
//						speedoffaling = -screenH / 2;
//						speedoffaling1 = -screenH / 2;
//						speedoffaling3 = -screenH / 2;
//						speedoffaling4 = -screenH / 2;
//
//						// u can still save yourself just touch her again
//						hd2.postDelayed(new Runnable() {
//
//							@Override
//							public void run() {
//								// TODO Auto-generated method stub
//								if (((touchX > placeoffaling2 - wid1) && (touchX < placeoffaling2
//										+ scabmp.getWidth() + wid1))
//										&& ((touchY < speedoffaling2
//												+ scabmp.getHeight() + hi1) && (touchY > speedoffaling2
//												- hi1))) {
//									stoppragnent2 = 10;
//								}
//							}
//						}, 10);
//
//						if (stoppragnent2 == 10) {
//							stoppragnent2 = 0;
//							count = 0;
//							speedoffaling2 = -screenH / 50;
//							speedoffaling2 += x * meter / 2;
//							hi2 = 100;
//							wid2 = 100;
//							age2++;
//						}
//					}
				} else if ((realage2 >= 28) && (realage2 < 45)) {
					// o.k this age for woman its also good
					score += (100 - realage2);

				} else {
					// baaaaaaa u make me puke u just lost 1 life
					lives--;

				}

				// play the bitmap again:
				age2 = 10 + agernd.nextInt(400);
				if ((count == 0)) {
					speedoffaling2 = -screenH / 50;

					if (statusofgame < 15) {
						placeoffaling2 = 2
								* screenW
								/ 3
								+ rnd.nextInt(screenW / 3
										- (scabmp.getWidth() / 2));

					} else {

						placeoffaling2 = 2
								* screenW
								/ 4
								+ rnd.nextInt(screenW / 4
										- (scabmp.getWidth() / 2));

					}

					speedoffaling2 += x2 * meter / 2;
				}
			}
			// if u missed the cucugirl and she run away
			if (speedoffaling2 > screenH) {
				age2 = 10 + agernd.nextInt(400);
				if (statusofgame < 15) {
					placeoffaling2 = 2
							* screenW
							/ 3
							+ rnd.nextInt(screenW / 3 - (scabmp.getWidth() / 2));

				} else {

					placeoffaling2 = 2
							* screenW
							/ 4
							+ rnd.nextInt(screenW / 4 - (scabmp.getWidth() / 2));

				}
				x2 = 1 + rnd.nextInt(6);
				speedoffaling2 = 0;
				speedoffaling2 += x2 * meter / 2;
			}
		}

		// //////////////////////////////////////////////////////////////////////////////////

		// move 4 cucu
		if (statusofgame <= 15) {
			x3 = 0;
		} else {
			if (count == 0) {
				x3 = 1 + rnd.nextInt(6);
				speedoffaling3 += x3 * meter / 2;
				age3++;
			}
//
//			 else{//if she is pragnent
//			 hi3+=meter/2;
//			 wid3+=meter/2;
//			
//			
//			 if((hi3>=sizeofbirth)||(wid3>=screenW/3)){
//			 //gameover!!!!!
//			
//			 //but now justforcheck:
//			 this.myactivity.runOnUiThread(new Runnable() {
//			
//			 @Override
//			 public void run() {
//			 // TODO Auto-generated method stub
//			
//			 makeMyDialogue(myactivity, score+"");
//			
//			 }
//			 });
//			
//			
//			 }
//			
//			
//			 }

			// see if i touched the bitmap:
			if (((touchX > placeoffaling3 - 10 * meter) && (touchX < placeoffaling3
					+ scabmp3.getWidth() + 10 * meter))
					&& ((touchY < speedoffaling3 + scabmp3.getHeight() + 10
							* meter) && (touchY > speedoffaling3 - 10 * meter))) {

				// add or remove points
				if (realage3 < 18) {
					// end of the game you r geting into jail u pedofil!!!!!
					// add endofgame method
				} else if ((realage3 >= 18) && (realage3 < 28)) {
					// goooodddddd u succeed to do fine lady
					score += (100 - realage) * 2;
					statusofgame++;

					// buttt now u should check if u got her pragnent

//					 ispregnent3=checkifpregnent.nextInt(chancetogetpragnent);
//					
//					 //oh-no she is pragnent
//					 if(ispregnent3==0){
//					 count++;
//					 speedoffaling1=-screenH/2;
//					 speedoffaling2=-screenH/2;
//					 speedoffaling=-screenH/2;
//					 speedoffaling4=-screenH/2;
//					
//					
//					 //u can still save yourself just touch her again
//					 hd2.postDelayed(new Runnable() {
//					
//					 @Override
//					 public void run() {
//					 // TODO Auto-generated method stub
//					 if(((touchX>placeoffaling3-wid3)&&(touchX<placeoffaling3+scabmp.getWidth()+wid3))&&
//					 ((touchY<speedoffaling3+scabmp.getHeight()+hi3)&&(touchY>speedoffaling3-hi3))){
//					 stoppragnent3=10;
//					 }
//					 }
//					 }, 10);
//					
//					 if (stoppragnent3==10){
//					 stoppragnent3=0;
//					 count=0;
//					 speedoffaling3=-screenH/50;
//					 speedoffaling3+=x*meter/2;
//					 hi3=100;
//					 wid3=100;
//					 age3++;
//					 }
//					
//					 }
//					

				} else if ((realage3 >= 28) && (realage3 < 45)) {
					// o.k this age for woman its also good
					score += (100 - realage3);

				} else {
					// baaaaaaa u make me puke u just lost 1 life
					lives--;

				}

				// play the bitmap again:
				age3 = 10 + agernd.nextInt(400);
				if ((count == 0) && (count1 == 0) && (count2 == 0)
						&& (count3 == 0) && (count4 == 0)) {
					speedoffaling3 = -screenH / 50;

					placeoffaling3 = 3
							* screenW
							/ 4
							+ rnd.nextInt(screenW / 4 - (scabmp.getWidth() / 2));

					speedoffaling3 += x3 * meter / 2;
				}
			}
			// if u missed the cucugirl and she run away
			if (speedoffaling3 > screenH) {
				age3 = 10 + agernd.nextInt(400);
				placeoffaling3 = 3 * screenW / 4
						+ rnd.nextInt(screenW / 4 - (scabmp.getWidth() / 2));
				x3 = 1 + rnd.nextInt(6);
				speedoffaling3 = 0;
				speedoffaling3 += x3 * meter / 2;
			}
		}

		
		//////////////////////////////////////////////////////////////////////////////////////////
//		// //move 5 cucu
//		// //we want only 4 right now
//		if (statusofgame <= 20) {
//			x4 = 0;
//		} else {
//			if (count == 0) {
//				x4 = 1 + rnd.nextInt(6);
//				speedoffaling4 += x4 * meter / 2;
//				age4++;
//			}
//
//			 else{//if she is pragnent
//			 hi4+=meter/2;
//			 wid4+=meter/2;
//			
//			
//			 if((hi4>=sizeofbirth)||(wid4>=sizeofbirth)){
//			 //gameover!!!!!
//			
//			 //but now justforcheck:
//			 this.myactivity.runOnUiThread(new Runnable() {
//			
//			 @Override
//			 public void run() {
//			 // TODO Auto-generated method stub
//			
//			 makeMyDialogue(myactivity, score+"");
//			
//			 }
//			 });
//			
//			
//			 }
//			
//			
//			 }
////			 see if i touched the bitmap:
//			if (((touchX > placeoffaling4 - 10 * meter) && (touchX < placeoffaling4
//					+ scabmp4.getWidth() + 10 * meter))
//					&& ((touchY < speedoffaling4 + scabmp4.getHeight() + 10
//							* meter) && (touchY > speedoffaling4 - 10 * meter))) {
//
//				// add or remove points
//				if (realage4 < 18) {
//					// end of the game you r geting into jail u pedofil!!!!!
//					// add endofgame method
//				} else if ((realage4 >= 18) && (realage4 < 28)) {
//					// goooodddddd u succeed to do fine lady
//					score += (100 - realage) * 2;
//					statusofgame++;
//
//					// buttt now u should check if u got her pragnent
//
//					 ispregnent4=checkifpregnent.nextInt(1000);
//					
////					 oh-no she is pragnent
//					 if(ispregnent4==0){
//					 count++;
//					 speedoffaling1=-scabmp1.getHeight();
//					 speedoffaling2=-scabmp2.getHeight();
//					 speedoffaling3=-scabmp3.getHeight();
//					 speedoffaling=-scabmp.getHeight();
//					
//					
//					 //u can still save yourself just touch her again
//					 hd2.postDelayed(new Runnable() {
//					
//					 @Override
//					 public void run() {
//					 // TODO Auto-generated method stub
//					 if(((touchX>placeoffaling4-wid4)&&(touchX<placeoffaling4+scabmp.getWidth()+wid4))&&
//					 ((touchY<speedoffaling4+scabmp.getHeight()+hi4)&&(touchY>speedoffaling4-hi4))){
//					 stoppragnent4=10;
//					 }
//					 }
//					 }, 10);
//					
//					 if (stoppragnent4==10){
//					 stoppragnent4=0;
//					 count=0;
//					 speedoffaling4=-screenH/50;
//					 speedoffaling4+=x*meter/2;
//					 hi4=100;
//					 wid4=100;
//					 age4++;
//					 }
//					
//					 }
//					
//					
//
//				} else if ((realage4 >= 28) && (realage4 < 45)) {
//					// o.k this age for woman its also good
//					score += (100 - realage4);
//
//				} else {
//					// baaaaaaa u make me puke u just lost 1 life
//					lives--;
//
//				}
//
//				// play the bitmap again:
//				// play the bitmap again:
//				age3 = 10 + agernd.nextInt(400);
//				if ((count == 0) && (count1 == 0) && (count2 == 0)
//						&& (count3 == 0) && (count4 == 0)) {
//
//					age4 = 10 + agernd.nextInt(400);
//					speedoffaling4 = -screenH / 50;
//					speedoffaling4 += x4 * meter / 2;
//					placeoffaling4 = rnd.nextInt(screenW);
//				}
//			}
//			// if u missed the cucugirl and she run away
//			if (speedoffaling4 > screenH) {
//				age4 = 10 + agernd.nextInt(400);
//				placeoffaling4 = rnd.nextInt(screenW);
//				x4 = 1 + rnd.nextInt(6);
//				speedoffaling4 = 0;
//				speedoffaling4 += x4 * meter / 2;
//			}
//		}

		
		
		
		
		
		
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

	public void drawGameElements(Canvas canvas) {
		// radius = 10 * meter;

		canvas.drawColor(Color.BLACK);

		// canvas.drawBitmap(bmp, touchX, touchY, ptext1);

		scabmp = Bitmap.createScaledBitmap(bmp, wid, hi, false);
		canvas.drawBitmap(scabmp, placeoffaling, speedoffaling, p1);
		scabmp1 = Bitmap.createScaledBitmap(bmp1, wid1, hi1, false);
		canvas.drawBitmap(scabmp1, placeoffaling1, speedoffaling1, p2);
		scabmp2 = Bitmap.createScaledBitmap(bmp2, wid2, hi2, false);
		canvas.drawBitmap(scabmp2, placeoffaling2, speedoffaling2, p3);
		scabmp3 = Bitmap.createScaledBitmap(bmp3, wid3, hi3, false);
		canvas.drawBitmap(scabmp3, placeoffaling3, speedoffaling3, p4);
//		scabmp4 = Bitmap.createScaledBitmap(bmp4, wid4, hi4, false);
//		canvas.drawBitmap(scabmp4, placeoffaling4, speedoffaling4, p5);

		// canvas.drawCircle(touchX, touchY, 100, ptext1);

		// this is for score
		canvas.drawText("age of 1: " + realage, meter * 10, meter * 10, ptext1);
		canvas.drawText("age of 2: " + realage1, meter * 10, meter * 20, ptext1);
		canvas.drawText("age of 3: " + realage2, meter * 10, meter * 30, ptext1);
		canvas.drawText("age of 4: " + realage3, meter * 10, meter * 40, ptext1);
		canvas.drawText("age of 5: " + realage4, meter * 10, meter * 50, ptext1);

		canvas.drawText("score: " + score, meter * 60, meter * 10, ptext1);
		canvas.drawText("lives: " + lives, meter * 130, meter * 30, ptext1);
	}

}
