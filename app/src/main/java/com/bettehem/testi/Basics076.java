package com.bettehem.testi;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.media.*;
import android.os.*;
import android.preference.*;
import android.view.*;
import android.widget.*;

public class Basics076 extends Activity implements View.OnClickListener
{
   MediaPlayer music;
   Button menuS;
   Intent menuSet;
   boolean musicset;
   
   @Override
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
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
	   setContentView(R.layout.basics076);
	   music = MediaPlayer.create(Basics076.this, R.raw.everlast);
	   SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
	   musicset = getPrefs.getBoolean("music_check", true);
	   if (musicset == true){
	   music.start();
	   }
	   menuS = (Button) findViewById(R.id.menuS);
	   menuS.setOnClickListener(this);
	   menuSet = new Intent("com.bettehem.testi.MENUSET076");
   }
   
   @Override
   public void onPause(){
	   super.onPause();
	   music.pause();
   }
   
   @Override
   public void onDestroy(){
	   super.onDestroy();
	   music.release();
   }
   
   public void onClick(View v){
	   switch(v.getId()){
		   case R.id.menuS:
		   startActivity(menuSet);
		   break;
	   }
   }
   
}
