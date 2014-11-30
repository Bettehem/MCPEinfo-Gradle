package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class PlayMenu076 extends Activity implements View.OnClickListener
{
   Button play, addworld, addserver;
   Intent playint, addwrldint, addsrvrint;
   
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
	   setContentView(R.layout.playmenu076);
	   
	   play = (Button) findViewById(R.id.playmenubtn);
	   addworld = (Button) findViewById(R.id.addworldbtn);
	   addserver = (Button) findViewById(R.id.addserverbtn);
	   playint = new Intent ("com.bettehem.testi.PLAYPIC076");
	   addwrldint = new Intent ("com.bettehem.testi.WORLDPIC076");
	   addsrvrint = new Intent ("com.bettehem.testi.SERVERPIC076");
	   
	   play.setOnClickListener(this);
	   addworld.setOnClickListener(this);
	   addserver.setOnClickListener(this);
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
