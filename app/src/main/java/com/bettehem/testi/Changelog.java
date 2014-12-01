package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.media.*;
import android.os.*;
import android.preference.*;
import android.view.*;
import android.graphics.*;
import android.widget.*;

public class Changelog extends Activity
{
   MediaPlayer music;
   boolean musicset;
   Typeface font;
   TextView header, log;
   
   @Override
   public void onCreate(Bundle k){
	   super.onCreate(k);
	   setContentView(R.layout.clog);
	   stuff();
	   
	   
	   View view = findViewById(R.id.backround);
	   int orientation = getResources().getConfiguration().orientation;
	   if (orientation == Configuration.ORIENTATION_LANDSCAPE){
		   view.setBackgroundResource(R.drawable.mcpewallvaaka);
	   }else{
		   view.setBackgroundResource(R.drawable.mcpeinfowall);
	   }
	   
   }
   
   public void stuff(){
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   music = MediaPlayer.create(Changelog.this, R.raw.everlast);
	   SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
	   musicset = getPrefs.getBoolean("music_check", true);
	   if (musicset == true){
	   music.start();
	   }
	   
	   header = (TextView) findViewById(R.id.clogheader);
	   log = (TextView) findViewById(R.id.clogtext);
	   
	   header.setTypeface(font);
	   log.setTypeface(font);
   }
   
   @Override
   public void onPause(){
	   super.onPause();
	   music.pause();
   }
   
   @Override
   public void onResume(){
	   super.onResume();
	   if (musicset == true){
	   music.start();
	   }
   }
   
}
