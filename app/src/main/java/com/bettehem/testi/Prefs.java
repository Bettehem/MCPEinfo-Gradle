package com.bettehem.testi;

import android.preference.*;
import android.os.*;
import android.annotation.SuppressLint;
import android.content.*;
import android.view.*;

public class Prefs extends PreferenceActivity
{
	Intent main;
	MenuItem settings, about;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
		stuff();
	}
	
	@SuppressLint("WrongViewCast")
	public void stuff(){
		main = new Intent ("com.bettehem.testi.MAINMENU");
		settings = (MenuItem) findViewById(R.id.settings);
		about = (MenuItem) findViewById(R.id.about);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		startActivity(main);
	}
	
	
	
}
