package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.media.*;
import android.os.*;
import android.preference.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class IntroDuction extends Activity implements View.OnClickListener
{
   MediaPlayer music;
   Button startB;
   Intent start;
   boolean musicset;
   TextView itext, header;
   String version;
   Typeface font;
   
   @Override
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   
	   
	   version = "080";//Current Basics version
	   
	   
	   setContentView(R.layout.introduction);
	   
	   startB = (Button) findViewById(R.id.goToBasics);
	   startB.setOnClickListener(this);
	   
	   itext = (TextView)findViewById(R.id.itext);
	   
	   music = MediaPlayer.create(IntroDuction.this, R.raw.everlast);
	   SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
	   musicset = getPrefs.getBoolean("music_check", true);
	   if (musicset == true){
	   music.start();
	   }
	   
	   View view = findViewById(R.id.backround);
	   int orientation = getResources().getConfiguration().orientation;
	   if (orientation == Configuration.ORIENTATION_LANDSCAPE){
		   view.setBackgroundResource(R.drawable.mcpewallvaaka);
	   }else{
		   view.setBackgroundResource(R.drawable.mcpeinfowall);
	   }
	   
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   header = (TextView) findViewById(R.id.introductionheader);
	   
	   startB.setTypeface(font);
	   itext.setTypeface(font);
	   header.setTypeface(font);
	   
   }
   
   @Override
   public void onDestroy(){
	   super.onDestroy();
	   music.release();
   }
   
   @Override
   public void onPause(){
	   super.onPause();
	   music.release();
   }
   
   @Override
   public void onResume(){
	   super.onResume();
	   if (musicset == true){
	   music.start();
	   }
   }
   
   public void onClick(View v){
	   switch (v.getId()){
		   case R.id.goToBasics:
			   start = new Intent("com.bettehem.testi.BASICS" + version);
			   startActivity(start);
			   finish();
		   break;
	   }
   }
   
}
