package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class PlayMenu080 extends Activity implements View.OnClickListener
{
   Button play, addworld, addserver;
   Intent playint, addwrldint, addsrvrint;
   TextView text1, text2, text3;
   Typeface font;
   
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
	   setContentView(R.layout.playmenu080);
	   
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   play = (Button) findViewById(R.id.playmenubtn);
	   addworld = (Button) findViewById(R.id.addworldbtn);
	   addserver = (Button) findViewById(R.id.addserverbtn);
	   playint = new Intent ("com.bettehem.testi.PLAYPIC080");
	   addwrldint = new Intent ("com.bettehem.testi.WORLDPIC080");
	   addsrvrint = new Intent ("com.bettehem.testi.SERVERPIC080");
	   
	   play.setOnClickListener(this);
	   addworld.setOnClickListener(this);
	   addserver.setOnClickListener(this);
	   
	   text1 = (TextView) findViewById(R.id.playmenu080text1);
	   text2 = (TextView) findViewById(R.id.playmenu080text2);
	   text3 = (TextView) findViewById(R.id.playmenu080text3);
	   
	   play.setTypeface(font);
	   addworld.setTypeface(font);
	   addserver.setTypeface(font);
	   text1.setTypeface(font);
	   text2.setTypeface(font);
	   text3.setTypeface(font);
   }
   
   
   public void onClick (View v){
	   switch (v.getId()){
		   case R.id.playmenubtn:
		   startActivity(playint);
		   break;
		   
		   case R.id.addworldbtn:
		   startActivity(addwrldint);
		   break;
		   
		   case R.id.addserverbtn:
		   startActivity(addsrvrint);
		   break;
	   }
   }
   
}
