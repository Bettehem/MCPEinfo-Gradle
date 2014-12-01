package com.bettehem.testi;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class HowToCraft080 extends Activity
{
	
	TextView header, text1, text2, text3;
	Typeface font;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.howtocraft080);
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
		
		header = (TextView) findViewById(R.id.howtocraft080header);
		text1 = (TextView) findViewById(R.id.howtocraft080text1);
		text2 = (TextView) findViewById(R.id.howtocraft080text2);
		text3 = (TextView) findViewById(R.id.howtocraft080text3);

		
		header.setTypeface(font);
		text1.setTypeface(font);
		text2.setTypeface(font);
		text3.setTypeface(font);

	}
}
