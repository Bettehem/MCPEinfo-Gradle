package com.bettehem.testi;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.res.*;
import android.graphics.*;
import android.widget.*;

public class HowToSmelt080 extends Activity
{
	Typeface font;
	TextView header, text1, text2, text3, text4, text5, text6;
	
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
		setContentView(R.layout.howtosmelt080);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		header = (TextView) findViewById(R.id.howtosmelt080header);
		text1 = (TextView) findViewById(R.id.howtosmelt080text1);
		text2 = (TextView) findViewById(R.id.howtosmelt080text2);
		text3 = (TextView) findViewById(R.id.howtosmelt080text3);
		text4 = (TextView) findViewById(R.id.howtosmelt080text4);
		text5 = (TextView) findViewById(R.id.howtosmelt080text5);
		text6 = (TextView) findViewById(R.id.howtosmelt080text6);
		
		header.setTypeface(font);
		text1.setTypeface(font);
		text2.setTypeface(font);
		text3.setTypeface(font);
		text4.setTypeface(font);
		text5.setTypeface(font);
		text6.setTypeface(font);

	}
}
