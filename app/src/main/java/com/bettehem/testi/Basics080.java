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

public class Basics080 extends Activity implements View.OnClickListener
{
   MediaPlayer music;
   Button menuS, crafting, furnace;
   Intent menuSet, craftTut, furnaceTut;
   boolean musicset;
   String pack;
   Typeface font;
   TextView header, text, old;
   
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
	   setContentView(R.layout.basics080);
	   
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   music = MediaPlayer.create(Basics080.this, R.raw.everlast);
	   SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
	   musicset = getPrefs.getBoolean("music_check", true);
	   if (musicset == true){
	   music.start();
	   }
	   
	   pack = "com.bettehem.testi.";
	   
	   menuS = (Button) findViewById(R.id.menuS);
	   menuS.setOnClickListener(this);
	   crafting = (Button) findViewById(R.id.craftingTut080);
	   crafting.setOnClickListener(this);
	   furnace = (Button) findViewById(R.id.furnaceTut080);
	   furnace.setOnClickListener(this);
	   
	   menuSet = new Intent(pack + "MENUSETTINGS080");
	   craftTut = new Intent(pack + "CRAFTING080");
	   furnaceTut = new Intent(pack + "FURNACE080");
	   
	   menuS.setTypeface(font);
	   crafting.setTypeface(font);
	   furnace.setTypeface(font);
	   
	   header = (TextView) findViewById(R.id.basics080header);
	   text = (TextView) findViewById(R.id.basics080text);
	   old = (TextView) findViewById(R.id.basics080old);
	   
	   header.setTypeface(font);
	   text.setTypeface(font);
	   old.setTypeface(font);
   }
   
   @Override
   public void onPause(){
	   super.onPause();
	   music.release();
   }
   
/*   @Override
   public void onResume(){
	   super.onResume();
	   
   } */
   
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
		   
		   case R.id.craftingTut080:
			   startActivity(craftTut);
			   break;
			   
		   case R.id.furnaceTut080:
			   startActivity(furnaceTut);
			   break;
	   }
   }
   
}
