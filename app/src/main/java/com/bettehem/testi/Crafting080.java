package com.bettehem.testi;
import android.app.*;
import android.view.*;
import android.os.*;
import android.content.res.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;

public class Crafting080 extends Activity implements View.OnClickListener
{
	Button learn;
	Intent howtocraft;
	TextView text1, text2, text3, header;
	Typeface font;
	
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
		setContentView(R.layout.crafting080);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		learn = (Button) findViewById(R.id.learnhowtocraft080);
		learn.setOnClickListener(this);
		
		howtocraft = new Intent("com.bettehem.testi.HOWTOCRAFT080");
		
		learn.setTypeface(font);
		
		text1 = (TextView) findViewById(R.id.crafting080text1);
		text2 = (TextView) findViewById(R.id.crafting080text2);
		text3 = (TextView) findViewById(R.id.crafting080text3);
		header = (TextView) findViewById(R.id.crafting080header);
		
		text1.setTypeface(font);
		text2.setTypeface(font);
		text3.setTypeface(font);
		header.setTypeface(font);
	}
	
	public void onClick(View v){
		switch (v.getId()){
			case R.id.learnhowtocraft080:
				startActivity(howtocraft);
				break;
		}
	}
}
