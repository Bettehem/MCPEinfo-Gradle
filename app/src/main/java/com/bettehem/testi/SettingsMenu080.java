package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.Typeface;
import android.os.*;
import android.view.*;
import android.widget.*;

public class SettingsMenu080 extends Activity implements View.OnClickListener
{
	Button gameset, ctrlset, graphset, soundset;
	Intent gamesetmenu, ctrlsetmenu, graphsetmenu, soundsetmenu;
	String name;
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
		setContentView(R.layout.settingsmenu080);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		gameset = (Button) findViewById(R.id.gameset);
		ctrlset = (Button) findViewById(R.id.ctrlset);
		graphset = (Button) findViewById(R.id.graphset);
		soundset = (Button) findViewById(R.id.soundset);
		
		gameset.setOnClickListener(this);
		ctrlset.setOnClickListener(this);
		graphset.setOnClickListener(this);
		soundset.setOnClickListener(this);
		
		name = "com.bettehem.testi.";
		
		gamesetmenu = new Intent (name + "GAMESETTINGS080");
		ctrlsetmenu = new Intent (name + "CONTROLSETTINGS080");
		graphsetmenu = new Intent (name + "GRAPHICSETTINGS080");
		soundsetmenu = new Intent (name + "SOUNDSETTINGS080");
		
		text = (TextView) findViewById(R.id.settingsmenu080text1);
		
		gameset.setTypeface(font);
		ctrlset.setTypeface(font);
		graphset.setTypeface(font);
		soundset.setTypeface(font);
		text.setTypeface(font);
	}
	
	public void onClick(View v){
		switch (v.getId()){
			
			case R.id.gameset:
			startActivity(gamesetmenu);
			break;
			
			case R.id.ctrlset:
			startActivity(ctrlsetmenu);
			break;
			
			case R.id.graphset:
			startActivity(graphsetmenu);
			break;
			
			case R.id.soundset:
			startActivity(soundsetmenu);
			break;
		}
	}
}
