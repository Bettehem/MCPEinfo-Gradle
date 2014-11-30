package com.bettehem.testi;

import android.app.*;
import android.content.res.*;
import android.graphics.Typeface;
import android.os.*;
import android.view.*;
import android.widget.TextView;

public class Upcoming extends Activity
{
	TextView text;
	Typeface font;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView (R.layout.upcoming);
		
		View view = findViewById(R.id.backround);
		   int orientation = getResources().getConfiguration().orientation;
		   if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			   view.setBackgroundResource(R.drawable.mcpewallvaaka);
		   }else{
			   view.setBackgroundResource(R.drawable.mcpeinfowall);
		   }
		
		   stuff();
	}
	
	public void stuff(){
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		text = (TextView) findViewById(R.id.upcomingtext);
		
		text.setTypeface(font);
	}
	
}
