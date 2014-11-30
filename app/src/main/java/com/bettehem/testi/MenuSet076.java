package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MenuSet076 extends Activity implements View.OnClickListener
{
   Button play, playor, settings;
   Intent playInt, playorInt, settingsInt;
   
   
   
   
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
	   setContentView(R.layout.menusettings076);
	   play = (Button) findViewById(R.id.play);
	   playor = (Button) findViewById(R.id.playor);
	   settings = (Button) findViewById(R.id.settings);
	   
	   playInt = new Intent("com.bettehem.testi.PLAYMENU076");
	   playorInt = new Intent("com.bettehem.testi.PLAYORMENU076");
	   settingsInt = new Intent("com.bettehem.testi.SETTINGSMENU076");
	   
	   play.setOnClickListener(this);
	   playor.setOnClickListener(this);
	   settings.setOnClickListener(this);
   }
   
   public void onClick(View v){
	   switch (v.getId()){
		   case R.id.play:
		   startActivity(playInt);
		   break;
		   
		   case R.id.playor:
		   startActivity(playorInt);
		   break;
		   
		   case R.id.settings:
		   startActivity(settingsInt);
		   break;
	   }
   }
}
