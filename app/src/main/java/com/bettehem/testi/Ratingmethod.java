package com.bettehem.testi;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Ratingmethod extends Activity implements View.OnClickListener{

	Button email, play;
	TextView text1;
	Typeface font;
	Intent rateapp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		setContentView(R.layout.ratingmethod);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		play = (Button) findViewById(R.id.rateonplay);
		email = (Button) findViewById(R.id.ratewithmail);
		text1 = (TextView) findViewById(R.id.ratingmethodtxt);
		
		play.setTypeface(font);
		email.setTypeface(font);
		text1.setTypeface(font);
		
		rateapp = new Intent(getPackageName() + ".RATING");
		
		play.setOnClickListener(this);
		email.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		
		case R.id.rateonplay:
			final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
			try {
			    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
			} catch (android.content.ActivityNotFoundException anfe) {
			    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
			}
			break;
			
		case R.id.ratewithmail:
			startActivity(rateapp);
			break;
		
		}
	}

}
