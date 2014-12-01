package com.bettehem.testi;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;

public class Furnace080 extends Activity implements View.OnClickListener
{
	Button crafting, furnace;
	Intent craftTut, furnaceTut;
	String pack = "com.bettehem.testi.";
	Typeface font;
	TextView header, text1, text2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
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
		setContentView(R.layout.furnace080);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		crafting = (Button) findViewById(R.id.craftingTut080);
		crafting.setOnClickListener(this);
		furnace = (Button) findViewById(R.id.learnhowtosmelt080);
		furnace.setOnClickListener(this);
		
		craftTut = new Intent(pack + "CRAFTING080");
		furnaceTut = new Intent(pack + "HOWTOSMELT080");
		
		header = (TextView) findViewById(R.id.furnace080header);
		text1 = (TextView) findViewById(R.id.furnace080text1);
		text2 = (TextView) findViewById(R.id.furnace080text2);
		
		crafting.setTypeface(font);
		furnace.setTypeface(font);
		header.setTypeface(font);
		text1.setTypeface(font);
		text2.setTypeface(font);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId()){
			case R.id.craftingTut080:
				startActivity(craftTut);
				break;
				
				case R.id.learnhowtosmelt080:
					startActivity(furnaceTut);
					break;
		}
	}
}
