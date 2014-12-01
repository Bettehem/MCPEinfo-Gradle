package com.bettehem.testi;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class ControlSettings080 extends Activity
{
	TextView text;
	Typeface font;
	
	@Override
	public void onCreate (Bundle savedInstanceState){
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
		setContentView(R.layout.ctrlset080);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		text = (TextView) findViewById(R.id.ctrlset080text);
		
		text.setTypeface(font);
	}
}
