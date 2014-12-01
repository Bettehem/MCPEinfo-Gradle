package com.bettehem.testi;

import android.app.*;
import android.os.*;
import android.graphics.*;
import android.widget.*;

public class About extends Activity
{
	Typeface font;
	TextView aboutText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		stuff();
	}

	public void stuff(){
		aboutText = (TextView) findViewById(R.id.aboutappText);
		
		aboutText.setTypeface(font);
	}
}
